package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class InvalidOprationException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1914193421273983448L;

	public InvalidOprationException() {
		super(ApplicationErrorCode.InvalidOpration.getCode(), ApplicationErrorCode.InvalidOpration.getReasoning());
	}

	public InvalidOprationException(String message) {
		super(ApplicationErrorCode.InvalidOpration.getCode(), message);
	}
	
}
