package org.shmztko.request;

/**
 * 外部へアクセスした際にエラーが発生したことを表す例外クラスです。
 * @author ShimizuTakeo
 */
public class RequestException extends RuntimeException {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = -8057815203892646927L;

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 */
	public RequestException() {
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param message エラーメッセージ
	 */
	public RequestException(String message) {
		super(message);
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param cause 原因となる例外
	 */
	public RequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param message エラーメッセージ
	 * @param cause 原因となる例外
	 */
	public RequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
