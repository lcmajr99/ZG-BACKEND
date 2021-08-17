package com.sysambientes.sysambientes.exceptions;

public class SysambientesException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SysambientesException() {
		super();
	}

	public SysambientesException(String message, Throwable cause) {
		super(message, cause);
	}

	public SysambientesException(String message) {
		super(message);
	}

	public SysambientesException(Throwable cause) {
		super(cause);
	}
	
}
