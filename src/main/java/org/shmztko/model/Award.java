package org.shmztko.model;

import org.javalite.activejdbc.Model;

/**
 * アワードを表すデータモデル
 * @author ShimizuTakeo
 */
public class Award extends Model {

	/**
	 * @return アワード名
	 */
	public String getAwardName() {
		return getString("award_name");
	}

	/**
	 * @param awardName アワード名
	 */
	public void setAwardName(String awardName) {
		set("award_name", awardName);
	}

	/**
	 * @return アワードの回数
	 */
	public int getAwardCount() {
		return getInteger("award_count");
	}

	/**
	 * @param awardCount アワードの回数
	 */
	public void setAwardCount(int awardCount) {
		set("award_count", awardCount);
	}
}
