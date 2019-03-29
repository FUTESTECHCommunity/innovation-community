package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class MessageQueneSendError extends ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6143786179537080160L;

	public MessageQueneSendError() {
		super(ApplicationErrorCode.MessageQueneSendError.getCode(), ApplicationErrorCode.MessageQueneSendError.getReasoning());
	}
}
