package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class InvalidRequestURLException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7205004837471524300L;

	public InvalidRequestURLException() {
		super(ApplicationErrorCode.InvalidRequestPath.getCode(),
				ApplicationErrorCode.InvalidRequestPath.getReasoning());
	}
}
