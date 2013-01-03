package org.shmztko.model;

import java.util.ResourceBundle;

import net.java.ao.EntityManager;

import org.javalite.activejdbc.Base;

/**
 * <p>
 * DataBaseへのアクセス用クラスです。<br/>
 * {@link EntityManager} だと、DBアクセスごとにSQLExceptionをtry~catchしないといけないので、
 * このクラスで例外をcatchしてRuntimeExecptionに変換して送出します。
 * </p>
 * @author ShimizuTakeo
 */
public final class DB {

	public static void open() {
		ResourceBundle bundle = ResourceBundle.getBundle("darts-statistics");
		Base.open(
				bundle.getString("db.driver"),
				bundle.getString("db.url"),
				bundle.getString("db.username"),
				bundle.getString("db.password")
		);
	}

	public static void close() {
		Base.close();
	}
}