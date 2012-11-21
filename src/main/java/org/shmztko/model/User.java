package org.shmztko.model;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 * ユーザを表すデータモデル
 * @author ShimizuTakeo
 */
public interface User extends Entity {

	/**
	 * カード名を取得します。
	 * @return カード名
	 */
	public String getCardName();

	/**
	 * カード名を設定します。
	 * @param cardName カード名
	 */
	public void setCardName(String cardName);

	/**
	 * メールアドレスを取得します。
	 * @return メールアドレス
	 */
	public String getEmail();
	/**
	 * メールアドレスを設定します。
	 * @param email メールアドレス
	 */
	public void setEmail(String email);

	/**
	 * ログインURLを取得します。
	 * @return ログインURL
	 */
	public String getLoginUrl();
	/**
	 * ログインURLを設定します。
	 * @param loginUrl ログインURL
	 */
	public void setLoginUrl(String loginUrl);

	/**
	 * 成績を取得します。
	 * @return 成績
	 */
	@OneToMany
	public Statistic[] getStatistics();
}
