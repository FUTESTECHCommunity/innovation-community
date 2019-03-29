package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class TimeoutCallingException extends ApplicationException {

	private static final long serialVersionUID = 2426099428515832936L;

	public TimeoutCallingException() {
		super(ApplicationErrorCode.TimeoutCall.getCode(), ApplicationErrorCode.TimeoutCall.getReasoning());
	}
}
