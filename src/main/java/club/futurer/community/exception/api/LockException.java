package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

/**
 * Created by yanbin on 2017/1/10.
 */
public class LockException extends ApplicationException{

    public LockException() {
        super(ApplicationErrorCode.LockError.getCode(), ApplicationErrorCode.LockError.getReasoning());
    }

    public LockException(Exception e) {
        super(ApplicationErrorCode.LockError.getCode(), e.getMessage());
    }
}
