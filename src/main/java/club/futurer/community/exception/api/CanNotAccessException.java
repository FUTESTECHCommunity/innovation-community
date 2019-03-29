package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class CanNotAccessException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404607636122554946L;

	public CanNotAccessException() {
		super(ApplicationErrorCode.CanNotAccessResource.getCode(), ApplicationErrorCode.CanNotAccessResource.getReasoning());
	}
}
