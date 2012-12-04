package org.shmztko.model;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import net.java.ao.DBParam;
import net.java.ao.DatabaseProvider;
import net.java.ao.Entity;
import net.java.ao.EntityManager;
import net.java.ao.Query;
import net.java.ao.schema.UnderscoreFieldNameConverter;
import net.java.ao.schema.UnderscoreTableNameConverter;

import org.shmztko.exceptions.ApplicationException;

/**
 * <p>
 * DataBaseへのアクセス用クラスです。<br/>
 * {@link EntityManager} だと、DBアクセスごとにSQLExceptionをtry~catchしないといけないので、
 * このクラスで例外をcatchしてRuntimeExecptionに変換して送出します。
 * </p>
 * @author ShimizuTakeo
 */
public final class DataBaseManager {

	/** 扱う対象となるモデルクラス一覧 */
	private static final List<Class<? extends Entity>> MODEL_CLASSES;

	static {
		// 順序大事
		MODEL_CLASSES = Arrays.asList(User.class, Statistic.class);
	}

	/** {@link EntityManager}のインスタンス */
	private EntityManager manager;

	/** このクラスの唯一のインスタンス */
	private static final DataBaseManager INSTANCE = new DataBaseManager();

	/**
	 * このクラスがインスタンス化される時に呼び出されます。
	 */
	private DataBaseManager() {
		ResourceBundle bundle = ResourceBundle.getBundle("darts-statistics");
		manager = new EntityManager(DatabaseProvider.getInstance(
				bundle.getString("db.url"),
				bundle.getString("db.username"),
				bundle.getString("db.password")
		));
		manager.setFieldNameConverter(new UnderscoreFieldNameConverter(false));
		manager.setTableNameConverter(new UnderscoreTableNameConverter(false));
	}

	/**
	 * このクラスのインスタンスを取得します。
	 * @return このクラスのインスタンス
	 */
	public static DataBaseManager getInstance() {
		return INSTANCE;
	}

	/**
	 * 指定したエンティティへ新しいオブジェクトを生成します。
	 * @param entity レコード作成対象のエンティティクラス
	 * @param dbParams 作成時に渡すDBのパラメータ
	 * @param <T> 指定したエンティティのクラス
	 * @return 作成したオブジェクト
	 */
	public <T extends Entity> T create(Class<T> entity, DBParam ...dbParams) {
		try {
			return manager.create(entity, dbParams);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to create records. -> " + entity.toString(), e);
		}
	}

	/**
	 * 指定したエンティティから、クエリ条件に一致するオブジェクトを検索します。
	 * @param entity 検索対象のエンティティ
	 * @param query 検索条件
	 * @param <T> 指定したエンティティのクラス
	 * @return 検索条件に一致したオブジェクト一覧
	 */
	public <T extends Entity> T[] find(Class<T> entity, Query query) {
		try {
			return manager.find(entity, query);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to find records. -> " + entity.toString(), e);
		}
	}

	/**
	 * 指定したエンティティから、全オブジェクトを検索します。
	 * @param entity 検索対象のエンティティ
	 * @param <T> 指定したエンティティのクラス
	 * @return 指定したエンティティの全オブジェクト
	 */
	public <T extends Entity> T[] find(Class<T> entity) {
		try {
			return manager.find(entity);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to find records. -> " + entity.toString(), e);
		}
	}

	/**
	 * 指定したエンティティ内の全てのオブジェクトを削除します。
	 * @param entity 削除対象のエンティティ
	 * @param <T> 指定したエンティティのクラス
	 */
	public <T extends Entity> void delete(Class<T> entity) {
		delete(find(entity));
	}

	/**
	 * 指定したオブジェクトを削除します。
	 * @param object 削除対象のオブジェクト
	 * @param <T> 指定したエンティティのクラス
	 */
	public <T extends Entity> void delete(T ... object) {
		try {
			manager.delete(object);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to delete records. -> " + object.toString(), e);
		}
	}

	/**
	 * 全エンティティを生成します。
	 */
	public void migrateAll() {
		for (Class<? extends Entity> clazz : MODEL_CLASSES) {
			migrate(clazz);
		}
	}

	/**
	 * エンティティを移行を行います。
	 * @param entities 移行対象エンティティ
	 */
	private void migrate(Class<? extends Entity> ... entities) {
		try {
			manager.migrate(entities);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to migrate. -> " + entities.toString(), e);
		}
	}
}