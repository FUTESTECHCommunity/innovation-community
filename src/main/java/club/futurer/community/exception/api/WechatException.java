package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class WechatException extends ApplicationException {
    /**
     *
     */
    private static final long serialVersionUID = 7117287618113840659L;

    public WechatException() {
        super(ApplicationErrorCode.WechatError.getCode(), ApplicationErrorCode.WechatError.getReasoning());
    }

    public WechatException(String msg) {
        super(ApplicationErrorCode.WechatError.getCode(), ApplicationErrorCode.WechatError.getReasoning() + " " + msg);
    }
}
