package org.shmztko.model;

import org.javalite.activejdbc.Base;
import org.shmztko.utils.PropertiesUtils;

/**
 * <p>
 * DataBaseの接続開始・終了を行うクラスです。
 * </p>
 * @author ShimizuTakeo
 */
public final class DB {

	/** プロパティ */
	private static final PropertiesUtils PROPS = new PropertiesUtils("/darts-statistics.properties");

	/**
	 * DBとの接続を開きます。
	 */
	public static void open() {
		Base.open(
				PROPS.getString("db.driver"),
				PROPS.getString("db.url"),
				PROPS.getString("db.username"),
				PROPS.getString("db.password")
		);
	}

	/**
	 * DBとの接続を閉じます。
	 */
	public static void close() {
		Base.close();
	}
}