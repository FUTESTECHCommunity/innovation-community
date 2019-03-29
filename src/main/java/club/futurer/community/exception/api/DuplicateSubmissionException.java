package club.futurer.community.exception.api;


import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class DuplicateSubmissionException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public DuplicateSubmissionException() {
		super(ApplicationErrorCode.DuplicateSubmit.getCode(), ApplicationErrorCode.DuplicateSubmit.getReasoning());
	}

	public DuplicateSubmissionException(Exception e) {
		super(ApplicationErrorCode.DuplicateSubmit.getCode(), e.getMessage());
	}
}
