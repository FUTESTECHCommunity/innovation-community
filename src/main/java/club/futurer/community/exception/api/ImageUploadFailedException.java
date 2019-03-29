package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class ImageUploadFailedException extends ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7117287618118746659L;

	public ImageUploadFailedException() {
		super(ApplicationErrorCode.ImageUploadFailed.getCode(),
				ApplicationErrorCode.ImageUploadFailed.getReasoning());
	}

	public ImageUploadFailedException(String msg) {
		super(ApplicationErrorCode.ImageUploadFailed.getCode(),
				ApplicationErrorCode.ImageUploadFailed.getReasoning() + " "
						+ msg);
	}
}
