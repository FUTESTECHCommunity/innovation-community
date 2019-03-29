package club.futurer.community.interceptor;

import com.google.gson.Gson;
import club.futurer.community.common.Result;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class ExceptionController extends AbstractErrorController {
    private final ErrorProperties errorProperties;

    public ExceptionController() {
        this(new DefaultErrorAttributes(), new ErrorProperties());
    }

    public ExceptionController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        this(errorAttributes, errorProperties, Collections.emptyList());
    }

    public ExceptionController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        Assert.notNull(errorProperties, "ErrorProperties must not be null");
        this.errorProperties = errorProperties;
    }

    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

//    去掉之后所有默认都返回Json，如果不去掉，则默认MediaType.TEXT_HTML走这里，其他走下面的方法。
//    @RequestMapping(
//            produces = {"text/html"}
//    )
//    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
//        HttpStatus status = this.getStatus(request);
//        Map model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.TEXT_HTML)));
//        response.setStatus(status.value());
//        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
//        return modelAndView == null?new ModelAndView("error", model):modelAndView;
//    }

    @RequestMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result<String> error(HttpServletRequest request) {
//        Request requestContent = new Request(request);
        Map body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = this.getStatus(request);

//        Map<String, String> content = new HashMap<>(2);
//        content.put("body", new Gson().toJson(new ResponseEntity(body, status)));
//        content.put("request", new GsonBuilder().serializeNulls().create().toJson(requestContent));
        Result<String> result = new Result<String>();
        result.setCode("" + status.value());
//        result.setData(new Gson().toJson(content));
//        result.setData(new GsonBuilder().serializeNulls().create().toJson(requestContent));
        result.setData(new Gson().toJson(new ResponseEntity(body, status)));
        result.setMsg("");
        return result;
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        ErrorProperties.IncludeStacktrace include = this.getErrorProperties().getIncludeStacktrace();
        return include == ErrorProperties.IncludeStacktrace.ALWAYS?true:(include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM?this.getTraceParameter(request):false);
    }

    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }
}
