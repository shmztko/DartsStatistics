package org.shmztko.accessor;

import org.shmztko.model.User;
import org.shmztko.request.Requester;
/**
 * 外部ページアクセス用クラスの基底クラス
 * @author ShimizuTakeo
 */
public abstract class PageAccessor {

	/** 外部ページアクセス用汎用クラス */
	private Requester requester;

	/**
	 * このクラスがインスタンス化される時に呼び出されます。
	 * @param user ページにアクセスするユーザ
	 */
	public PageAccessor(User user) {
		requester = new Requester();

		setProxy();

		// 初回ログインで認証情報をクッキーに保持させる
		requester.get(user.getLoginUrl());
	}

	/**
	 * 指定されたURLに応じたページ内容を取得します。
	 * @param location Webページなどのロケーション
	 * @return ページ内容
	 */
	protected String getPageContent(String location) {
		return requester.get(location);
	}

	/**
	 * システムプロパティからプロキシの設定を行います。
	 */
	private void setProxy() {
		String proxyHost = System.getProperty("http.proxyHost");
		String proxyPort = System.getProperty("http.proxyPort");

		if (proxyHost == null || proxyHost.length() <= 0) {
			return;
		}

		if (proxyPort == null || proxyPort.length() <= 0) {
			return;
		}
		requester.setProxy(proxyHost, Integer.parseInt(proxyPort));
	}
}
