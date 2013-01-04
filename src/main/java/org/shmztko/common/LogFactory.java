package org.shmztko.common;

import java.util.logging.Logger;

/**
 * ロガーを生成するファクトリクラスです。
 * @author ShimizuTakeo
 */
public class LogFactory {

	/**
	 * クラス名を元にロガーを取得します。
	 * @param clazz クラス名
	 * @return ロガー
	 */
	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	/**
	 * ロガー名文字列を元にロガーを取得します。
	 * @param loggerName ロガー名
	 * @return ロガー
	 */
	public static Logger getLogger(String loggerName) {
		return Logger.getLogger(loggerName);
	}
}


