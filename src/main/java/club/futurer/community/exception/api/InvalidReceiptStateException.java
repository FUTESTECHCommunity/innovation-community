package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;


public class InvalidReceiptStateException extends ApplicationException {

	private static final long serialVersionUID = -698281893764433657L;

	public InvalidReceiptStateException() {
		super(ApplicationErrorCode.InvalidReceiptState.getCode(), ApplicationErrorCode.InvalidReceiptState.getReasoning());
	}

	public InvalidReceiptStateException(String reasoning) {
		super(ApplicationErrorCode.InvalidReceiptState.getCode(), reasoning);
	}
}
