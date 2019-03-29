package club.futurer.community.common;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYC on 2017/4/18.
 */
public class Trace {
    private static final String ApplicationBugStatucCode = "120";
    private static final String ApplicationExceptionStatusCode = "110";

    //打印异常堆栈信息
    public static String printTrace(Exception ex){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        return stringWriter.toString();
    }

//    public static StatusReply handleException(Exception ex, Logger logger) {
//        StatusReply.Builder statusReplyBuilder = StatusReply.newBuilder();
//        if(ex instanceof BusinessException) {//业务异常
//            BusinessException businessException = (BusinessException) ex;
//            statusReplyBuilder.setStatusCode(StatusType.BusinessException.getStatusCode()).setErrorCode(businessException.getErrorCode()).setMessage(businessException.getErrorMessage());
//            logger.warn(businessException.toString());
//        }else if(ex instanceof BusinessInvalidArgumentException) {//参数异常
//            BusinessInvalidArgumentException invalidArgumentException = (BusinessInvalidArgumentException) ex;
//            statusReplyBuilder.setStatusCode(StatusType.InvalidArgument.getStatusCode()).setErrorCode(invalidArgumentException.getErrorCode()).setMessage(invalidArgumentException.getErrorMessage());
//            logger.warn(invalidArgumentException.toString());
//        }else if(ex instanceof RuntimeException) {//程序存在bug
//            String message = Trace.printTrace(ex);
//            statusReplyBuilder.setStatusCode(StatusType.ApplicationBug.getStatusCode()).setErrorCode(ApplicationBugStatucCode).setMessage(message);
//            logger.warn(message);
//        }else {//已受检异常，应用程序级别的错误
//            String message = Trace.printTrace(ex);
//            statusReplyBuilder.setStatusCode(StatusType.ApplicationException.getStatusCode()).setErrorCode(ApplicationExceptionStatusCode).setMessage(message);
//            logger.warn(message);
//        }
//        return statusReplyBuilder.build();
//    }
//
//    public static StatusReply handleInvalidArgumentException(List<BusinessInvalidArgumentException> exceptionList, Logger logger) {
//        StatusReply.Builder statusReplyBuilder = StatusReply.newBuilder();
//        List<String> errorCodeList = new ArrayList<String>(exceptionList.size());
//        List<String> errorMessageList = new ArrayList<String>(exceptionList.size());
//        for(BusinessInvalidArgumentException exception : exceptionList) {
//            errorCodeList.add(exception.getErrorCode());
//            errorMessageList.add(exception.getErrorMessage());
//        }
//        String errorCodes = StringUtils.join(errorCodeList, ",");
//        String errorMessages = StringUtils.join(errorMessageList, ",");
//        BusinessInvalidArgumentException exception = new BusinessInvalidArgumentException(errorCodes, errorMessages);
//        statusReplyBuilder.setStatusCode(StatusType.InvalidArgument.getStatusCode()).setErrorCode(errorCodes).setMessage(errorMessages);
//        logger.warn(exception.toString());
//        return statusReplyBuilder.build();
//    }
}
