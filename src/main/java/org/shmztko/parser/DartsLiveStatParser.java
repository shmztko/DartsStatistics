package org.shmztko.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.shmztko.model.User;
import org.shmztko.request.Requester;


public class DartsLiveStatParser {

	private Requester requester;

	private User user;

	public DartsLiveStatParser(User user) {
		requester = new Requester();
		requester.setProxy(
				System.getProperty("http.proxyHost"),
				Integer.parseInt(System.getProperty("http.proxyPort"))
		);

		// 初回ログインで認証情報をクッキーに保持させる
		requester.get(user.getLoginUrl());
	}

	public void parse() {
		Document doc = Jsoup.parse(requester.get(DartsLivePages.PLAYDATA.getUrl()));

		System.out.println(doc.toString());
	}



	private enum DartsLivePages {
		PLAYDATA("http://card.dartslive.com/t/playdata.jsp");

		private String url;

		private DartsLivePages(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}
}