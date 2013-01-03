package org.shmztko.exec;

import java.util.List;
import java.util.logging.Logger;

import org.shmztko.common.LogFactory;
import org.shmztko.model.DB;
import org.shmztko.model.User;
import org.shmztko.recorder.DartsLiveRecorder;

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
		LOG.info("Record playdata start");
		try {
			DB.open();
			List<User> users = User.findAll();
			DartsLiveRecorder recorder = new DartsLiveRecorder();
			for (User user : users) {
				LOG.info("Recording statistics for user -> " + user.getCardName());
				recorder.record(user);
			}			
		} finally {
			DB.close();
			LOG.info("Record playdata end");
		}
	}
}