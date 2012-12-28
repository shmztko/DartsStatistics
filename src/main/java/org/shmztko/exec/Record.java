package org.shmztko.exec;

import org.shmztko.model.DataBaseManager;
import org.shmztko.model.User;
import org.shmztko.recorder.DartsLiveStatRecorder;

/**
 * 成績を記録するための、コマンドラインからの実行用クラスです。
 * @author ShimizuTakeo
 */
public class Record {

	/**
	 * コマンドラインから実行された際に呼ばれるメソッド
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		User[] users = DataBaseManager.getInstance().find(User.class);
		for (User user : users) {
			new DartsLiveStatRecorder(user).record();
		}
	}
}