package org.shmztko.accessor;

import org.shmztko.model.User;
import org.shmztko.request.Requester;

public abstract class PageAccessor {

	private Requester requester;

	public PageAccessor(User user) {
		requester = new Requester();
		requester.setProxy(
				System.getProperty("http.proxyHost"),
				Integer.parseInt(System.getProperty("http.proxyPort"))
		);

		// 初回ログインで認証情報をクッキーに保持させる
		requester.get(user.getLoginUrl());
	}

	protected String getPageContent(String location) {
		return requester.get(location);
	}
}
