package org.shmztko.exec;

import org.shmztko.model.DataBaseManager;

/**
 * 初期DBスキーマを生成するための、コマンドラインからの実行用クラスです。
 * @author ShimizuTakeo
 */
public class Migrate {

	/**
	 * コマンドラインから実行された際に呼ばれるメソッド
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		DataBaseManager.getInstance().migrateAll();
	}
}
