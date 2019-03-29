package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class ImageRecommendFailedException extends ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7117287618118746659L;

	public ImageRecommendFailedException() {
		super(ApplicationErrorCode.ImageRecommendFailed.getCode(),
				ApplicationErrorCode.ImageRecommendFailed.getReasoning());
	}

	public ImageRecommendFailedException(String msg) {
		super(ApplicationErrorCode.ImageRecommendFailed.getCode(),
				ApplicationErrorCode.ImageRecommendFailed.getReasoning() + " "
						+ msg);
	}
}
