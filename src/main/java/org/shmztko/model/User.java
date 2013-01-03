package org.shmztko.model;

/**
 * ユーザを表すデータモデル
 * @author ShimizuTakeo
 */
public class User extends Model {

	/**
	 * @return カード名
	 */
	public String getCardName() {
		return (String)getValue("card_name");
	}

	/**
	 * @param cardName カード名
	 */
	public void setCardName(String cardName) {
		setValue("card_name", cardName);
	}

	/**
	 * @return メールアドレス
	 */
	public String getEmail() {
		return (String)getValue("email");
	}
	/**
	 * @param email メールアドレス
	 */
	public void setEmail(String email) {
		setValue("email", email);
	}

	/**
	 * @return ログインURL
	 */
	public String getLoginUrl() {
		return (String)getValue("login_url");
	}
	/**
	 * @param loginUrl ログインURL
	 */
	public void setLoginUrl(String loginUrl) {
		setValue("login_url", loginUrl);
	}

}
