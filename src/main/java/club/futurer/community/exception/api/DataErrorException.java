package club.futurer.community.exception.api;

import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;

public class DataErrorException extends ApplicationException {

	private static final long serialVersionUID = 3569122469449985345L;

	public DataErrorException(Exception e) {
		super(ApplicationErrorCode.DataError.getCode(), e.getMessage());
	}
	
	

}
