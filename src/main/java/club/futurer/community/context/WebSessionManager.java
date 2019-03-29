//package club.futurer.community.context;
//
//import com.google.gson.Gson;
//import club.futurer.community.common.CacheKeyPrefix;
//import club.futurer.community.common.IRedisCacheClient;
//import club.futurer.community.common.UuidUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Component
//public class WebSessionManager {
//
//    private static final int DefaultTimeOut = 20 * 60;
//
//    private static final String DefaultCacheKeyPrefix = CacheKeyPrefix.UserSession.getKey();
//
//    private int timeout;
//
//    private String cacheKeyPrefix;
//
//    @Autowired
//    private IRedisCacheClient cacheClient;
//
//    /**
//     * 每个用户只允许一个会话。
//     */
//    private boolean singlePerUser;
//
//    public WebSessionManager() {
//        timeout = DefaultTimeOut;
//        cacheKeyPrefix = DefaultCacheKeyPrefix;
//    }
//
//    public int getTimeout() {
//        return timeout;
//    }
//
//    public void setTimeout(int timeout) {
//        this.timeout = timeout;
//    }
//
//    public String getCacheKeyPrefix() {
//        return cacheKeyPrefix;
//    }
//
//    public void setCacheKeyPrefix(String cacheKeyPrefix) {
//        this.cacheKeyPrefix = cacheKeyPrefix;
//    }
//
//    public boolean getSinglePerUser() {
//        return singlePerUser;
//    }
//
//    public void setSinglePerUser(boolean singlePerUser) {
//        this.singlePerUser = singlePerUser;
//    }
//
//    /**
//     * 新增 Web 会话。
//     *
//     * @param webSession
//     *            Web 会话
//     * @return Web 会话。
//     */
//    public WebSession add(WebSession webSession) {
//        String sessionId = newId(webSession);
//        return this.add(webSession, sessionId);
//    }
//
//    /**
//     * 新增 Web 会话。
//     *
//     * @param webSession
//     *            Web 会话
//     * @return Web 会话。
//     */
//    public WebSession add(WebSession webSession, String sessionId) {
//        webSession.setStartTime(new Date());
//        webSession.setSecretKey(newSecretKey());
//        if (null == webSession.getTenantId()) {
//            webSession.setTenantId(0L);
//        }
//        webSession.setId(sessionId);
//        String cacheKey = getCacheKey(webSession.getId());
//        getCacheClient().set(cacheKey, new Gson().toJson(webSession, WebSession.class), getTimeout());
//        return webSession;
//    }
//
//    /**
//     * 删除 Web 会话。
//     */
//    public void delete(String sessionId) {
//        String cacheKey = getCacheKey(sessionId);
//        getCacheClient().delete(cacheKey);
//    }
//
//    /**
//     * 获取 Web 会话。
//     *
//     * @param sessionId
//     *            Web 会话 ID
//     * @return Web 会话。
//     */
//    public WebSession get(String sessionId) {
//        String cacheKey = getCacheKey(sessionId);
//        IRedisCacheClient cacheClient = getCacheClient();
//        String cacheValue = cacheClient.get(cacheKey);
//        WebSession webSession = new Gson().fromJson(cacheValue, WebSession.class);
//        if (null != webSession) {
//            cacheClient.touch(cacheKey, getTimeout());
//        }
//        return webSession;
//    }
//
//    protected String newSecretKey() {
//        return UuidUtil.newUuidString();
//    }
//
//    protected String getCacheKey(String sessionId) {
//        String key;
//        // 如每用户只允许一个会话，会话ID中保存用户ID（32位）
//        // 占用后40位，其中最后8位保留 UUID 数据
//        if (singlePerUser) {
//            String userIdString = sessionId.substring(sessionId.length() - 10,
//                    sessionId.length() - 2);
//            long userId = Long.parseLong(userIdString, 16);
//            key = getCacheKeyPrefix() + userId;
//        } else {
//            key = getCacheKeyPrefix() + sessionId;
//        }
//        return key;
//    }
//
//    protected String newId(WebSession webSession) {
//        UUID uuid = UUID.randomUUID();
//        long least = uuid.getLeastSignificantBits();
//        // 如每用户只允许一个会话，保存用户ID（32位）
//        // 占用后40位，其中最后8位保留 UUID 数据
//        if (singlePerUser) {
//            least = least & 0xffffff00000000ffL | (webSession.getUserId() << 8);
//        }
//        return Long.toHexString(uuid.getMostSignificantBits())
//                + Long.toHexString(least);
//    }
//
//    protected IRedisCacheClient getCacheClient() {
//        return cacheClient;
//    }
//}
