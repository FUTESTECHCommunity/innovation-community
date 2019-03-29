package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class UserNameNotExistException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public UserNameNotExistException() {
		super(ApplicationErrorCode.UserNameNotExist.getCode(), ApplicationErrorCode.UserNameNotExist.getReasoning());
	}

	public UserNameNotExistException(Exception e) {
		super(ApplicationErrorCode.UserNameNotExist.getCode(), e.getMessage());
	}
}
