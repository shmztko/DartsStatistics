package org.shmztko.model;

import java.util.Date;

/**
 * 成績を表すデータモデル
 * @author ShimizuTakeo
 */
public class Statistic extends Model {

	/**
	 * @return プレイしたゲームの名前
	 */
	public String getGameName() {
		return (String)getValue("game_name");
	}
	/**
	 * @param gameName プレイしたゲームの名前
	 */
	public void setGameName(String gameName) {
		setValue("game_name", gameName);
	}

	/**
	 * @return プレイしたゲームの形式
	 */
	public String getGameFormat() {
		return (String)getValue("game_format");
	}
	/**
	 * @param gameFormat プレイしたゲームの形式
	 */
	public void setGameFormat(String gameFormat) {
		setValue("game_format", gameFormat);
	}

	/**
	 * @return ゲームのスコア
	 */
	public String getScore() {
		return (String)getValue("score");
	}
	/**
	 * @param score ゲームのスコア
	 */
	public void setScore(String score) {
		setValue("score", score);
	}

	/**
	 * @return プレイ人数
	 */
	public int getNumberOfPlayers() {
		return (Integer)getValue("number_of_players");
	}

	/**
	 * @param numberOfPlayers プレイ人数
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		setValue("number_of_players", numberOfPlayers);
	}

	/**
	 * @return ゲームのプレイ順
	 */
	public int getGameOrder() {
		return (Integer)getValue("game_order");
	}
	/**
	 * @param gameOrder ゲームのプレイ順
	 */
	public void setGameOrder(int gameOrder) {
		setValue("game_order", gameOrder);
	}

	public Date getPlayedAt() {
		return (Date)getValue("played_at");
	}
	
	public void setPlayedAt(Date playedAt) {
		setValue("played_at", playedAt);
	}
	
	public void setUser(User user) {
		setValue("user", user);
	}

	public User getUser() {
		return (User) getValue("user");
	}
}
