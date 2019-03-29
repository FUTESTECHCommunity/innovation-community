package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class ArgumentsIncorrectException extends ApplicationException {

	private static final long serialVersionUID = -698281893764433657L;

	public ArgumentsIncorrectException() {
		super(ApplicationErrorCode.ArgumentsIncorrect.getCode(), ApplicationErrorCode.ArgumentsIncorrect.getReasoning());
	}

	public ArgumentsIncorrectException(String reasoning) {
		super(ApplicationErrorCode.ArgumentsIncorrect.getCode(), reasoning);
	}
}
