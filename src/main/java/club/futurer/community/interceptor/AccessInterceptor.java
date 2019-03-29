//package club.futurer.community.interceptor;
//
//import club.futurer.community.common.WebUtils;
//import club.futurer.community.context.*;
//import club.futurer.community.exception.api.InvalidAccessTokenException;
//import org.apache.commons.lang3.StringUtils;
////import org.apache.log4j.MDC;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class AccessInterceptor implements HandlerInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(AccessInterceptor.class.getName());
//
//    @Autowired
//    private WebSessionManager webSessionManager;
//
//    @Autowired
//    private CacheManager cacheManager;
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Cache cache = cacheManager.getCache();
//        cache.
////        Request requestContent = new Request(request);
////        logger.info(requestContent.toString());
////        MDC.put("ip", WebUtils.Http.getIpAddr(request));
//        String userAgent = WebUtils.Http.getUserAgent(request);
////        MDC.put("profile", null == userAgent ? "EmptyUserAgent" : userAgent);
//        if (StringUtils.isBlank(request.getRequestURI())) {
////            MDC.put("url", "none");
//        } else {
//            String url = request.getRequestURI();
//            if (StringUtils.isNotBlank(request.getQueryString())) {
//                url = url + "?"+request.getQueryString();
//            }
////            MDC.put("url", url);
//        }
////        MDC.put("method", WebUtils.Http.getMethod(request));
//        WebContext webContext = buildWebContext(request, response);
//        boolean nonSessionValidation = false;
//        if (handler instanceof HandlerMethod) {
//            ApiMethodAttribute methodAttribute = ((HandlerMethod) handler).getMethod().getAnnotation(ApiMethodAttribute.class);
//            if (null != methodAttribute) {
//                nonSessionValidation = methodAttribute.nonSessionValidation();
//                webContext.setMethodAttribute(methodAttribute);
//            }
//        }
//        if (!request.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            WebSession webSession = validationSession(request, webContext, nonSessionValidation);
//            loggerUserInfo(webSession);
//        }
//        String sessionId = WebUtils.Session.getSessionId(request);
//        if (!StringUtils.isBlank(sessionId)) {
////            MDC.put("sessionId", sessionId);
//        }
//        return true;
//    }
//
//    private WebContext buildWebContext(HttpServletRequest request,
//                                       HttpServletResponse response) {
//        WebContext webContext = new WebContext();
//        webContext.setRequest(request);
//        webContext.setResponse(response);
//        ThreadWebContextHolder.setContext(webContext);
//        return webContext;
//    }
//
//    private WebSession validationSession(HttpServletRequest request,
//                                         WebContext webContext, boolean nonSessionValidation) {
//        WebSession webSession = null;
//        if (!nonSessionValidation) {
//            String sessionId = WebUtils.Session.getSessionId(request);
//            if (StringUtils.isBlank(sessionId)) {
//                throw new InvalidAccessTokenException();
//            }
//            webSession = webSessionManager.get(sessionId);
//            if (null == webSession || !sessionId.equals(webSession.getId())) {
//                throw new InvalidAccessTokenException();
//            }
//        }
//        if (null != webSession) {
//            webContext.setWebSession(webSession);
//        }
//        return webSession;
//    }
//
//    private void loggerUserInfo(WebSession webSession) {
//        if (null != webSession) {
//            if (null != webSession.getClientTypeId()) {
////                MDC.put("clientTypeID",
////                        null == webSession.getClientTypeId() ? "" : webSession
////                                .getClientTypeId().toString());
//            }
//            if (null != webSession.getUserId()) {
////                MDC.put("userId", null == webSession.getUserId() ? ""
////                        : webSession.getUserId().toString());
//            }
//            if (null != webSession.getUserName()) {
////                MDC.put("userName", webSession.getUserName());
//            }
//        }
//    }
//
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String accept = request.getHeader("Accept");
//        if (MediaType.APPLICATION_JSON_VALUE.equals(accept) || MediaType.ALL_VALUE.equals(accept)) {
//            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        }
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
