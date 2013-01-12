package org.shmztko.recorder;

import java.util.List;
import java.util.logging.Logger;

import org.shmztko.accessor.PageAccessor;
import org.shmztko.accessor.RemotePageAccessor;
import org.shmztko.common.LogFactory;
import org.shmztko.model.Award;
import org.shmztko.model.Record;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.parser.DartsLiveParser;
import org.shmztko.utils.DateUtils;

/**
 * DartsLiveの成績を保存するクラスです。
 * @author ShimizuTakeo
 */
public class DartsLiveRecorder {

	/** ロガー */
	private static final Logger LOG = LogFactory.getLogger(DartsLiveRecorder.class);
	
	/** ページアクセス用クラス */
	private PageAccessor accessor;

	/**
	 * @param accessor ページアクセス用クラス
	 */
	public void setPageAccessor(PageAccessor accessor) {
		this.accessor = accessor;
	}

	/**
	 * 成績をデータベースへ保存します。
	 * @param user 成績記録対象ユーザ
	 */
	public void record(User user) {
		if (accessor == null) {
			accessor = new RemotePageAccessor(user);
		}
		DartsLiveParser parser = new DartsLiveParser(accessor);

		List<Statistic> stats = parser.getYesterdayStats();
		List<Award> awards = parser.getYesterdayAwards();

		if (stats.isEmpty() && awards.isEmpty()) {
			LOG.info("No Statistcs or Awards to record.");
			return;

		} else {
			LOG.info("Found statistics or awards to record.");
			LOG.info("Statistics ¥t-> " + stats.size());
			LOG.info("Awards ¥t->" + awards.size());

			Record record = new Record();
			record.setPlayedAt(DateUtils.getYesterday());
			// MEMO:一度DBへ保存した状態からでないと、関連付いたレコードを追加できないため、先にsaveする。
			record.saveIt();

			record.addStatistics(stats);
			record.addAwards(awards);

			user.addRecord(record);
			user.saveIt();			
		}
	}
}