package com.ityongman.spring.generic;

public class GenericSpringEvent<T> {
	private T data ;
	protected boolean success ;
	
	public GenericSpringEvent(T data, boolean success) {
		this.data = data ;
		this.success = success ;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
