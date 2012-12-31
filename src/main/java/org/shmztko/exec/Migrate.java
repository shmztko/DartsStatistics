package org.shmztko.exec;

import java.util.logging.Logger;

import org.shmztko.common.LogFactory;
import org.shmztko.model.DataBaseManager;

/**
 * 初期DBスキーマを生成するための、コマンドラインからの実行用クラスです。
 * @author ShimizuTakeo
 */
public class Migrate {

	/** ロガー */
	private static final Logger LOG = LogFactory.getLogger(Migrate.class);

	/**
	 * コマンドラインから実行された際に呼ばれるメソッド
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		LOG.info("DB Migration start");
		DataBaseManager.getInstance().migrateAll();
		LOG.info("DB Migration end");
	}
}
