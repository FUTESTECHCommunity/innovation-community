package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class HttpMessageConverterException extends ApplicationException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816977676843453669L;

	public HttpMessageConverterException() {
		super(ApplicationErrorCode.HTTPMessageConvert.getCode(), ApplicationErrorCode.HTTPMessageConvert.getReasoning());
	}

	public HttpMessageConverterException(Exception e) {
		super(ApplicationErrorCode.HTTPMessageConvert.getCode(), e.getMessage());
	}
}
