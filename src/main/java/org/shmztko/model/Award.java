package org.shmztko.model;

import org.javalite.activejdbc.Model;

public class Award extends Model {

	public String getAwardName() {
		return getString("award_name");
	}

	public void setAwardName(String awardName) {
		set("award_name", awardName);
	}

	public int getAwardCount() {
		return getInteger("award_count");
	}

	public void setAwardCount(int awardCount) {
		set("award_count", awardCount);
	}
}
