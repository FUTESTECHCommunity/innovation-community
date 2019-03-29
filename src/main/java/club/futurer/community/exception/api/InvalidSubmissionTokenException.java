package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class InvalidSubmissionTokenException extends ApplicationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1256203906542662748L;

	public InvalidSubmissionTokenException() {
		super(ApplicationErrorCode.InvalidSubmissionToken.getCode(), ApplicationErrorCode.InvalidSubmissionToken.getReasoning());
	}

	public InvalidSubmissionTokenException(Exception e) {
		super(ApplicationErrorCode.InvalidSubmissionToken.getCode(), e.getMessage());
	}
}
