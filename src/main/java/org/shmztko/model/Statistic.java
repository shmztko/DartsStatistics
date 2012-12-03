package org.shmztko.model;

import java.util.Date;

import net.java.ao.Entity;

/**
 * 成績を表すデータモデル
 * @author ShimizuTakeo
 */
public interface Statistic extends Entity {

	/**
	 * @return プレイしたゲームの名前
	 */
	public String getGameName();
	/**
	 * @param gameName プレイしたゲームの名前
	 */
	public void setGameName(String gameName);

	/**
	 * @return プレイしたゲームの形式
	 */
	public String getGameFormat();
	/**
	 * @param gameFormat プレイしたゲームの形式
	 */
	public void setGameFormat(String gameFormat);

	/**
	 * @return ゲームのスコア
	 */
	public String getScore();
	/**
	 * @param score ゲームのスコア
	 */
	public void setScore(String score);

	/**
	 * @return playedAt プレイ日付
	 */
	public Date getPlayedAt();
	/**
	 * @param playedAt プレイ日付
	 */
	public void setPlayedAt(Date playedAt);

	/**
	 * @return プレイ人数
	 */
	public int getNumberOfPlayers();
	/**
	 * @param numberOfPlayers プレイ人数
	 */
	public void setNumberOfPlayers(int numberOfPlayers);

	/**
	 * @return プレイしたユーザ
	 */
	public User getUser();
	/**
	 * @param user プレイしたユーザ
	 */
	public void setUser(User user);

	/**
	 * @return ゲームのプレイ順
	 */
	public int getGameOrder();
	/**
	 * @param gameOrder ゲームのプレイ順
	 */
	public void setGameOrder(int gameOrder);
}
