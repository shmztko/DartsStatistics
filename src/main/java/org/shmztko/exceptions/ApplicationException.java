package org.shmztko.exceptions;
/**
 * このアプリケーション固有の例外クラスです。
 * @author ShimizuTakeo
 */
public class ApplicationException extends RuntimeException {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1143381854109120574L;

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 */
	public ApplicationException() {
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param message エラーメッセージ
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param cause 原因となる例外
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * このクラスがインスタンス化される時に呼び出されます
	 * @param message エラーメッセージ
	 * @param cause 原因となる例外
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
