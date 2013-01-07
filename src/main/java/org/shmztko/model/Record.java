package org.shmztko.model;

import java.util.Date;
import java.util.List;

import org.javalite.activejdbc.Model;

public class Record extends Model {

	public Date getPlayedAt() {
		return getDate("played_at");
	}

	public void setPlayedAt(Date playedAt) {
		set("played_at", playedAt);
	}
	
	public List<Statistic> getStatistics() {
		return getAll(Statistic.class);
	}

	public void addStatistic(Statistic statistic) {
		add(statistic);
	}

	public void addStatistics(List<Statistic> statistics) {
		for (Statistic statistic : statistics) {
			addStatistic(statistic);
		}
	}
	
	public List<Award> getAwards() {
		return getAll(Award.class);
	}

	public void addAward(Award award) {
		add(award);
	}

	public void addAwards(List<Award> awards) {
		for (Award award : awards) {
			addAward(award);
		}
	}
}
