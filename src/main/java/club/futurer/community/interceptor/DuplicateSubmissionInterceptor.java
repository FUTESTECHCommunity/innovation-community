//package club.futurer.community.interceptor;
//
//import com.google.gson.Gson;
//import club.futurer.community.common.IRedisCacheClient;
//import club.futurer.community.common.WebUtils;
//import club.futurer.community.common.duplicate.DuplicateSubmissionAnnotation;
//import club.futurer.community.common.duplicate.DuplicateSubmissionToken;
//import club.futurer.community.common.duplicate.DuplicateSubmissionTokenProcessor;
//import club.futurer.community.exception.api.DuplicateSubmissionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
//
///**
// * 避免重复提交拦截器
// */
//@Component
//public class DuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
//
//    private static final int AVOID_DUPLICATE_TIME = 6;
//
//    @Autowired
//    private IRedisCacheClient cacheClient;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            Gson gson = new Gson();
//            DuplicateSubmissionAnnotation annotation = method.getAnnotation(DuplicateSubmissionAnnotation.class);
//            if (null != annotation) {
//                String sessionId = WebUtils.Session.get().getId();
//                boolean validateToken = annotation.validateToken();
//                if (validateToken) {
//                    String cacheKey = DuplicateSubmissionTokenProcessor.getCacheKey(sessionId, annotation.businessType());
//                    DuplicateSubmissionToken token = gson.fromJson(cacheClient.get(cacheKey), DuplicateSubmissionToken.class);
//                    if (token == null) {
//                        token = new DuplicateSubmissionToken();
//                        token.getSubmited().set(true);
//                        cacheClient.set(cacheKey, gson.toJson(token), AVOID_DUPLICATE_TIME);
//                    } else {
//                        throw new DuplicateSubmissionException();
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean isDupilicateSubmit(HttpServletRequest request, DuplicateSubmissionToken cacheToken) {
//        if (cacheToken != null) {
//            return true;
//        }
//        return false;
//    }
//}