//package club.futurer.community.interceptor;
//
//import club.futurer.community.common.identity.*;
//import com.google.gson.Gson;
//import club.futurer.community.common.Cryptos;
//import club.futurer.community.common.IRedisCacheClient;
//import club.futurer.community.common.WebUtils;
//import club.futurer.community.exception.api.InvalidOprationException;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.time.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Method;
//import java.util.Date;
//
//
///**
// * 身份验证拦截器
// */
//@Component
//public class IdentityInterceptor implements HandlerInterceptor {
//
//    private static final String IDENTITY_TOKEN_KEY = "identityToken";
//
//    @Autowired
//    private IRedisCacheClient cacheClient;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            return true;
//        }
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            Gson gson = new Gson();
//            if (validIdentity(request, method, gson)) return true;
//            if (validDeviceIdentity(request, method, gson)) return true;
//            if (validPhoneIdentity(request, method, gson)) return true;
//        }
//        return true;
//    }
//
//    private boolean validIdentity(HttpServletRequest request, Method method, Gson gson) throws UnsupportedEncodingException {
//        IdentityAnnotation annotation = method.getAnnotation(IdentityAnnotation.class);
//        if (null != annotation) {
//            boolean needValidateToken = annotation.validateToken();
//            if (needValidateToken) {
//                String sessionId = WebUtils.Session.get().getId();
//                String cacheKey = IdentityTokenProcessor.getCacheKey(sessionId);
//                IdentityToken token = gson.fromJson(cacheClient.get(cacheKey), IdentityToken.class);
//                if (null != token) {
//                    if (isInvalidToken(request, token)) {
//                        throw new InvalidOprationException();
//                    }
//                    return true;
//                }
//                throw new InvalidOprationException();
//            }
//        }
//        return false;
//    }
//
//    private boolean validDeviceIdentity(HttpServletRequest request, Method method, Gson gson) throws UnsupportedEncodingException {
//        DeviceIdentity annotation = method.getAnnotation(DeviceIdentity.class);
//        if (null != annotation) {
//            boolean needValidateToken = annotation.validateToken();
//            if (needValidateToken) {
//                String sessionId = WebUtils.Session.get().getId();
//                String cacheKey = IdentityTokenProcessor.getDeviceCacheKey(sessionId, WebUtils.Session.getDeviceId(request));
//                IdentityDeviceToken token = gson.fromJson(cacheClient.get(cacheKey), IdentityDeviceToken.class);
//                if (null != token) {
//                    if (isInvalidDeviceToken(request, token)) {
//                        throw new InvalidOprationException();
//                    }
//                    return true;
//                }
//                throw new InvalidOprationException();
//            }
//        }
//        return false;
//    }
//
//    private boolean validPhoneIdentity(HttpServletRequest request, Method method, Gson gson) throws UnsupportedEncodingException {
//        PhoneIdentity annotation = method.getAnnotation(PhoneIdentity.class);
//        if (null != annotation) {
//            boolean needValidateToken = annotation.validateToken();
//            if (needValidateToken) {
//                String cacheKey = IdentityTokenProcessor.getPhoneCacheKey(WebUtils.Http.getIpAddr(request));
//                IdentityMobileToken token = gson.fromJson(cacheClient.get(cacheKey), IdentityMobileToken.class);
//                if (null != token) {
//                    if (isInvalidMobileToken(request, token)) {
//                        throw new InvalidOprationException();
//                    }
//                    return true;
//                }
//                throw new InvalidOprationException();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//    private boolean isInvalidToken(HttpServletRequest request, IdentityToken cacheToken) throws UnsupportedEncodingException {
//        String requestToken = request.getHeader(IDENTITY_TOKEN_KEY);
//        if (null == cacheToken || !cacheToken.getToken().equals(requestToken)) {
//            return true;
//        }
//        String decryptString = Cryptos.aesDecrypt(IdentityTokenProcessor.hexStringToByte(requestToken),
//                IdentityTokenProcessor.AES_KEY.getBytes("utf-8"));
//        String[] tmpArray = decryptString.split("_");
//        return !WebUtils.Http.getIpAddr(request).equals(tmpArray[2]);
//    }
//
//    private boolean isInvalidDeviceToken(HttpServletRequest request, IdentityDeviceToken cacheToken) throws UnsupportedEncodingException {
//        String requestToken = request.getHeader(IDENTITY_TOKEN_KEY);
//        if (null == cacheToken || !cacheToken.getToken().equals(requestToken)) {
//            return true;
//        }
//        String decryptString = Cryptos.aesDecrypt(IdentityTokenProcessor.hexStringToByte(requestToken),
//                IdentityTokenProcessor.AES_KEY.getBytes("utf-8"));
//        String[] tmpArray = decryptString.split("_");
//        return !WebUtils.Session.getSessionId(request).equals(tmpArray[0])
//                || !WebUtils.Session.getDeviceId(request).equals(tmpArray[3]);
//    }
//
//    private boolean isInvalidMobileToken(HttpServletRequest request, IdentityMobileToken cacheToken) throws UnsupportedEncodingException {
//        String requestToken = request.getHeader(IDENTITY_TOKEN_KEY);
//        if (StringUtils.isBlank(requestToken)){
//            return true;
//        }
//        String[] tokens = requestToken.split("_");
//        if (tokens.length != 2) {
//            return true;
//        }
//        if (null == cacheToken || !cacheToken.getToken().equals(tokens[0])) {
//            return true;
//        }
//        String decryptString = Cryptos.aesDecrypt(IdentityTokenProcessor.hexStringToByte(tokens[0]),
//                IdentityTokenProcessor.AES_KEY.getBytes("utf-8"));
//        String[] tmpArray = decryptString.split("_");
//        Date now = new Date();
//        Date tokenDate = DateUtils.addDays(cacheToken.getDate(), 1);
//        return !tokens[1].equals(cacheToken.getMobile()) || !tmpArray[0].equals(tokens[1]) ||
//                now.compareTo(tokenDate) == 1 || !cacheToken.getMobile().equals(tmpArray[0])
//                || !cacheToken.getIp().equals(WebUtils.Http.getIpAddr(request)) || !tmpArray[2].equals(WebUtils.Http.getIpAddr(request));
//    }
//}