package org.shmztko.request;

public class RequestException extends RuntimeException {

	private static final long serialVersionUID = -8057815203892646927L;

	public RequestException() {
	}

	public RequestException(String message) {
		super(message);
	}

	public RequestException(Throwable cause) {
		super(cause);
	}

	public RequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
