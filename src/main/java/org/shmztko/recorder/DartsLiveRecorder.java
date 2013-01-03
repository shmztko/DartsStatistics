package org.shmztko.recorder;

import java.util.List;

import org.shmztko.accessor.RemotePageAccessor;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.parser.DartsLiveParser;

/**
 * DartsLiveの成績を保存するクラスです。
 * @author ShimizuTakeo
 */
public class DartsLiveRecorder {

	/**
	 * このクラスがインスタンス化される時に呼び出されます。
	 */
	public DartsLiveRecorder() {
	}

	/**
	 * 成績をデータベースへ保存します。
	 */
	public void record(User user) {
		DartsLiveParser parser = new DartsLiveParser(new RemotePageAccessor(user));
		List<Statistic> stats = parser.getYesterdayStats();
		for (Statistic stat : stats) {
			stat.setUser(user);
			stat.saveIt();
		}
	}
}