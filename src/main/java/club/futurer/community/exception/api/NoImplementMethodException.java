package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class NoImplementMethodException extends ApplicationException {

	private static final long serialVersionUID = 1517704979366289472L;

	public NoImplementMethodException() {
		super(ApplicationErrorCode.NoImplementMethod.getCode(),
				ApplicationErrorCode.NoImplementMethod.getReasoning());
	}

	public NoImplementMethodException(String message) {
		super(ApplicationErrorCode.NoImplementMethod.getCode(),
				ApplicationErrorCode.NoImplementMethod.getReasoning() + ":"
						+ message);
	}
}
