package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class InvalidPasswordException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
		super(ApplicationErrorCode.InvalidPassword.getCode(), ApplicationErrorCode.InvalidPassword.getReasoning());
	}

	public InvalidPasswordException(Exception e) {
		super(ApplicationErrorCode.InvalidPassword.getCode(), e.getMessage());
	}
}
