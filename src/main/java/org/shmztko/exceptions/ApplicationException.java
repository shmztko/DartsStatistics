package org.shmztko.exceptions;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1143381854109120574L;

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
