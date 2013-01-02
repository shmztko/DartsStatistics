package org.shmztko.accessor;

import org.shmztko.model.User;
import org.shmztko.request.Requester;
/**
 * DartsLiveのカードページにアクセスするクラス
 * @author ShimizuTakeo
 */
public class RemotePageAccessor implements PageAccessor {

	/** 外部ページアクセス用汎用クラス */
	private Requester requester;

	/**
	 * このクラスのインスタンスが生成される時に呼び出されます。
	 * @param user アクセスするカードページの対象ユーザ
	 */
	public RemotePageAccessor(User user) {
		requester = new Requester();

		setProxy();

		// 初回ログインで認証情報をクッキーに保持させる
		requester.get(user.getLoginUrl());
	}

	@Override
	public String getPage(String location) {
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
