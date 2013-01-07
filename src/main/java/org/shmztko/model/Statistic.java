package org.shmztko.model;

import org.javalite.activejdbc.Model;

/**
 * 成績を表すデータモデル
 * @author ShimizuTakeo
 */
public class Statistic extends Model {

	/**
	 * @return プレイしたゲームの名前
	 */
	public String getGameName() {
		return getString("game_name");
	}
	/**
	 * @param gameName プレイしたゲームの名前
	 */
	public void setGameName(String gameName) {
		set("game_name", gameName);
	}

	/**
	 * @return プレイしたゲームの形式
	 */
	public String getGameFormat() {
		return getString("game_format");
	}
	/**
	 * @param gameFormat プレイしたゲームの形式
	 */
	public void setGameFormat(String gameFormat) {
		set("game_format", gameFormat);
	}

	/**
	 * @return ゲームのスコア
	 */
	public String getScore() {
		return getString("score");
	}
	/**
	 * @param score ゲームのスコア
	 */
	public void setScore(String score) {
		set("score", score);
	}

	/**
	 * @return プレイ人数
	 */
	public int getNumberOfPlayers() {
		return getInteger("number_of_players");
	}

	/**
	 * @param numberOfPlayers プレイ人数
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		set("number_of_players", numberOfPlayers);
	}

	/**
	 * @return ゲームのプレイ順
	 */
	public int getGameOrder() {
		return getInteger("game_order");
	}
	/**
	 * @param gameOrder ゲームのプレイ順
	 */
	public void setGameOrder(int gameOrder) {
		set("game_order", gameOrder);
	}
}
