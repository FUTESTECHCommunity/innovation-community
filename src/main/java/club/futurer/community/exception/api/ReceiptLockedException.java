package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;


public class ReceiptLockedException extends ApplicationException {

	private static final long serialVersionUID = -698281893764433657L;

	public ReceiptLockedException() {
		super(ApplicationErrorCode.LockedReceipt.getCode(), ApplicationErrorCode.LockedReceipt.getReasoning());
	}

	public ReceiptLockedException(String reasoning) {
		super(ApplicationErrorCode.LockedReceipt.getCode(), reasoning);
	}
}
