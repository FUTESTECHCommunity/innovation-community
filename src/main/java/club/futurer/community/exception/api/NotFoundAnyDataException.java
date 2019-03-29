package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class NotFoundAnyDataException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2830025252331466928L;

	public NotFoundAnyDataException() {
		super(ApplicationErrorCode.NotFoundAnyData.getCode(),
				ApplicationErrorCode.NotFoundAnyData.getReasoning());
	}
}
