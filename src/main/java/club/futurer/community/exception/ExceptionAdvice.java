package club.futurer.community.exception;

//import org.apache.log4j.Logger;
//import org.slf4j.MDC;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
///**
// * Created by yanbin on 2016/10/15.
// */
//
//@ControllerAdvice
//@ResponseBody
//@CrossOrigin
//public class ExceptionAdvice {
//
//
//    @Autowired
//    private PrintExceptionTraceConfig printExceptionTraceConfig;
//
//    private static final Logger logger = Logger
//            .getLogger(ExceptionAdvice.class);
//
//    /**
//     * 400 - Bad Request
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public JsonExceptionWrapper handleHttpMessageNotReadableException(
//            HttpMessageNotReadableException e) {
//        return wrapperException(e);
//    }
//
//    /**
//     * 405 - Method Not Allowed
//     */
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public JsonExceptionWrapper handleHttpRequestMethodNotSupportedException(
//            HttpRequestMethodNotSupportedException e) {
//        return wrapperException(e);
//    }
//
//    /**
//     * 415 - Unsupported Media Type
//     */
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public JsonExceptionWrapper handleHttpMediaTypeNotSupportedException(
//            Exception e) {
//        return wrapperException(e);
//    }
//
//    /**
//     * 500 - Internal Server Error
//     */
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(Throwable.class)
//    public JsonExceptionWrapper handleException(Throwable e) {
//        return wrapperException(e);
//    }
//
//    private JsonExceptionWrapper wrapperException(Throwable e) {
//        logger.error(e, e);
//        String exceptionTrace = JsonExceptionWrapper.getStackTrace(e);
//        JsonExceptionWrapper result = new JsonExceptionWrapper(e);
//
//        // print the exception stack trace
//        if (printExceptionTraceConfig.isPrintStackTrace()
//                && result.getCode().equals(ApplicationErrorCode.UnKnowException.getCode())) {
//            result.setMsg("发生未捕获的异常: " + exceptionTrace);
//        }
//
//        // handle the web access exceptions
//        if (e instanceof IOException && MDC.get("url") != null
//                && MDC.get("url").contains("/meallinkapi/error/404")) {
//            return result;
//        }
//
//        return result;
//    }
//}