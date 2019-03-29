package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class HttpClientException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public HttpClientException() {
		super(ApplicationErrorCode.HttpClient.getCode(), ApplicationErrorCode.HttpClient.getReasoning());
	}

	public HttpClientException(Exception e) {
		super(ApplicationErrorCode.HttpClient.getCode(), e.getMessage());
	}
}
