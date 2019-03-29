package club.futurer.community.common;

import java.util.concurrent.TimeUnit;

public enum CacheKeyPrefix {

//    MobileVerifyCode("mobile_ver_", "手机验证码", TimeUnit.MINUTES.toSeconds(3)),
//    GraphicVerifyCode("graphic_ver_", "图形验证码", TimeUnit.MINUTES.toSeconds(15)),
//    DuplicateSubmission("dup_sub_", "重复提交验证", TimeUnit.SECONDS.toSeconds(30)),
//    Identity("identity_", "身份验证", TimeUnit.DAYS.toSeconds(1)),
//    UserSession("user_session_", "用户Session", TimeUnit.DAYS.toSeconds(7));
    ;

    private CacheKeyPrefix(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    private CacheKeyPrefix(String value, String desc, long timeout) {
        this.key = value;
        this.desc = desc;
        this.timeout = timeout;
    }

    private String key;

    private String desc;

    private long timeout;

    /**
     * @return the value
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

}
