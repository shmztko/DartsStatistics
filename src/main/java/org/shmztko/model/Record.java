package org.shmztko.model;

import java.util.Date;
import java.util.List;

import org.javalite.activejdbc.Model;

/**
 * 成績記録を表すデータモデルです
 * @author ShimizuTakeo
 */
public class Record extends Model {

	/**
	 * @return プレイ日
	 */
	public Date getPlayedAt() {
		return getDate("played_at");
	}

	/**
	 * @param playedAt プレイ日
	 */
	public void setPlayedAt(Date playedAt) {
		set("played_at", playedAt);
	}

	/**
	 * @return 成績一覧
	 */
	public List<Statistic> getStatistics() {
		return getAll(Statistic.class);
	}

	/**
	 * @param statistic 成績
	 */
	public void addStatistic(Statistic statistic) {
		add(statistic);
	}

	/**
	 * @param statistics 成績一覧
	 */
	public void addStatistics(List<Statistic> statistics) {
		for (Statistic statistic : statistics) {
			addStatistic(statistic);
		}
	}

	/**
	 * @return アワード一覧
	 */
	public List<Award> getAwards() {
		return getAll(Award.class);
	}

	/**
	 * @param award アワード
	 */
	public void addAward(Award award) {
		add(award);
	}

	/**
	 * @param awards アワード一覧
	 */
	public void addAwards(List<Award> awards) {
		for (Award award : awards) {
			addAward(award);
		}
	}
}
