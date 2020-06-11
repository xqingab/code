package org.forten.sample;

import java.util.Date;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Date errorTime;

	public MyException() {
		super();
		this.errorTime = new Date();
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		this.errorTime = new Date();
	}

	public MyException(String message) {
		super(message);
		this.errorTime = new Date();
	}

	public MyException(Throwable cause) {
		super(cause);
		this.errorTime = new Date();
	}

	public Date getErrorTime() {
		return errorTime;
	}
}
