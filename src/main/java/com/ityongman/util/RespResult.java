package com.ityongman.util;

public class RespResult<T> {
	/**
	 * 返回码
	 */
	private int code ;
	
	/**
	 * 原因
	 */
	private String reason ;
	
	/**
	 * 操作结果
	 */
	private int result ;
	
	/**
	 * 响应数据
	 */
	private T data ;
	
	public static <T> RespResult<T> failResult(int code, String failMsg) {
		RespResult<T> result = new RespResult<T>() ;
		
		result.setCode(code);
		result.setReason(failMsg);
		result.setResult(0);
		
		return result ;		
	}
	
	public static <T> RespResult<T> successResult(int code, T data) {
		RespResult<T> result = new RespResult<T>() ;
		
		result.setCode(code);
		result.setData(data);
		result.setResult(1);
		
		return result;
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
