package org.shmztko.exec;

import java.util.logging.Logger;

import org.shmztko.accessor.RemotePageAccessor;
import org.shmztko.common.LogFactory;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.User;
import org.shmztko.recorder.DartsLiveStatRecorder;

/**
 * 成績を記録するための、コマンドラインからの実行用クラスです。
 * @author ShimizuTakeo
 */
public class Record {

	/** ロガー */
	private static final Logger LOG = LogFactory.getLogger(Record.class);
	
	/**
	 * コマンドラインから実行された際に呼ばれるメソッド
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		LOG.info("Record statistics start");
		User[] users = DataBaseManager.getInstance().find(User.class);
		for (User user : users) {
			LOG.info("Recording statistics for user -> " + user.getCardName());
			DartsLiveStatRecorder recorder = new DartsLiveStatRecorder(user);
			recorder.setPageAccessor(new RemotePageAccessor(user));
			recorder.record();
		}
		LOG.info("Record statistics end");
	}
}