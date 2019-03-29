package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class InvalidAccessTokenException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7117287618118746659L;

	public InvalidAccessTokenException() {
		super(ApplicationErrorCode.InvaliAccessToken.getCode(), ApplicationErrorCode.InvaliAccessToken.getReasoning());
	}
}
