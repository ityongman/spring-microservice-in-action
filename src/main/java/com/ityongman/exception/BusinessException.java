
package com.ityongman.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public int errCode ;
	
	public BusinessException(int errCode, String msg) {
		super(msg);
		this.errCode = errCode ;
	}
}
