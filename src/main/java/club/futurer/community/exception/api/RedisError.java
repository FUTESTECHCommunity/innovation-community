package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class RedisError extends ApplicationException {
	
	private static final long serialVersionUID = -5002758391134630754L;

	public RedisError() {
		super(ApplicationErrorCode.RedisError.getCode(), ApplicationErrorCode.RedisError.getReasoning());
	}
	
	public RedisError(String msg) {
		super(ApplicationErrorCode.RedisError.getCode(), ApplicationErrorCode.RedisError.getReasoning() + " " +  msg);
	}
}

