package org.shmztko.recorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.shmztko.accessor.DartsLivePageAccessor;
import org.shmztko.exceptions.ApplicationException;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.utils.DateUtils;

/**
 * DartsLiveの成績を保存するクラスです。
 * @author ShimizuTakeo
 */
public class DartsLiveStatRecorder {

	/** 成績取得元ページへのアクセス用クラス */
	private DartsLivePageAccessor accessor;

	/** 成績取得対象ユーザ */
	private User user;

	/**
	 * このクラスがインスタンス化される時に呼び出されます。
	 * @param user 成績取得対象ユーザ
	 */
	public DartsLiveStatRecorder(User user) {
		this.user = user;
		this.accessor = new DartsLivePageAccessor(user);
	}

	/**
	 * @param accessor 成績取得元ページへのアクセス用クラス
	 */
	public void setDartsLivePageAccessor(DartsLivePageAccessor accessor) {
		this.accessor = accessor;
	}

	/**
	 * 成績をデータベースへ保存します。
	 */
	public void record() {
		recordScoreResultOfYesterday();
	}

	/**
	 * 昨日の成績を取得しデータベースへ保存します。
	 */
	private void recordScoreResultOfYesterday() {
		Document doc = Jsoup.parse(accessor.getPlayDataPage());

		Elements elements = doc.select("#yesterday .result");

		if (elements.size() <= 0) {
			throw new ApplicationException("Failed to get playdata pages");
		}

		Element element = elements.get(0);
		String gameName = "";
		int gameOrder = 0;
		for (Element childElement : element.children()) {
			String className = childElement.className();

			if (!className.equals("resultLi")) {
				gameName = childElement.text();
				gameOrder = 0;

			} else {
				Element gameElement = childElement.select(".gameList").get(0);
				Elements gameList = gameElement.children();

				int players = gameList.size();
				Element score = gameList.select(".point.own").get(0);

				Statistic statistic = DataBaseManager.getInstance().create(Statistic.class);
				statistic.setGameName(gameName);
				statistic.setGameFormat(score.parent().className());
				statistic.setGameOrder(gameOrder++);
				statistic.setNumberOfPlayers(players);
				statistic.setPlayedAt(DateUtils.getYesterday());
				statistic.setScore(score.text());
				statistic.setUser(user);
				statistic.save();
			}
		}
	}
}