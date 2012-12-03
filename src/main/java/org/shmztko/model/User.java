package org.shmztko.model;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 * ユーザを表すデータモデル
 * @author ShimizuTakeo
 */
public interface User extends Entity {

	/**
	 * @return カード名
	 */
	public String getCardName();

	/**
	 * @param cardName カード名
	 */
	public void setCardName(String cardName);

	/**
	 * @return メールアドレス
	 */
	public String getEmail();
	/**
	 * @param email メールアドレス
	 */
	public void setEmail(String email);

	/**
	 * @return ログインURL
	 */
	public String getLoginUrl();
	/**
	 * @param loginUrl ログインURL
	 */
	public void setLoginUrl(String loginUrl);

	/**
	 * @return 成績
	 */
	@OneToMany
	public Statistic[] getStatistics();
}
