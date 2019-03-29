package club.futurer.community.interceptor;

import club.futurer.community.common.Result;
import club.futurer.community.common.StatusType;
import club.futurer.community.common.TraceUtil;
import club.futurer.community.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZYC on 2017/5/18.
 * 针对全局BusinessException的异常处理器Controller范围内(拦截的是RequestMapping抛出的异常)
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());

//    @ExceptionHandler(value=InvalidAccessTokenException.class)
//    @ResponseBody
//    public Result<String> errorHandler(HttpServletRequest request, HttpServletResponse response, InvalidAccessTokenException exception) {
//        Result<String> result = new Result<>();
//        result.setCode(StatusType.BusinessException.getStatusCode());
//        response.setStatus(200);
////        if(exception instanceof BusinessException) {
////            BusinessException businessException = (BusinessException) exception;
////            result.setCode(StatusType.BusinessException.getStatusCode());
////            result.setError(businessException.getErrorCode());
////            result.setMessage(businessException.getErrorMessage());
////        }else{
////            result.setCode(StatusType.ApplicationException.getStatusCode());
////        }
//        result.setData(exception.getMessage());
//        result.setMessage(InvalidAccessTokenException.class.getName());
//        logger.warn(TraceUtil.exception(exception));
//        return result;
//    }

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result<String> errorHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        Result<String> result = new Result<>();
        result.setCode("" + StatusType.BusinessException.getStatusCode());
        response.setStatus(200);
        if(exception instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) exception;
//            result.setData();
            result.setMsg(applicationException.getReasoning());
        }else {
//            result.setData(exception.getMessage());
            result.setMsg(exception.getClass().getName());
        }
        logger.warn(TraceUtil.exception(exception));
        result.setData("");
        return result;
    }

//    @ExceptionHandler(value=BusinessException.class)
//    @ResponseBody
//    public Result<String> errorHandler(HttpServletRequest request, BusinessException businessException) {
//        Result<String> result = new Result<>();
//        result.setCode(StatusType.BusinessException.getStatusCode());
//        result.setError(businessException.getErrorCode());
//        result.setMessage(businessException.getErrorMessage());
//        result.setData(TraceUtil.exception(businessException));
//        logger.warn(result.toString());
//        return result;
//    }

}
