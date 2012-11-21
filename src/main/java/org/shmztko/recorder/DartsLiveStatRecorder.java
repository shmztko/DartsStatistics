package org.shmztko.recorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.shmztko.accessor.DartsLivePageAccessor;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.utils.DateUtils;


public class DartsLiveStatRecorder {

	private DartsLivePageAccessor accessor;

	private User user;

	public DartsLiveStatRecorder(User user) {
		this.user = user;
		this.accessor = new DartsLivePageAccessor(user);
	}

	public void setDartsLivePageAccessor(DartsLivePageAccessor accessor) {
		this.accessor = accessor;
	}

	public void record() {
		recordScoreResultOfYesterday();
	}

	private void recordScoreResultOfYesterday() {
		Document doc = Jsoup.parse(accessor.getPlayDataPage());

		Element element = doc.select("#yesterday .result").get(0);

		String gameName = "";

		for (Element childElement : element.children()) {
			String className = childElement.className();

			if (!className.equals("resultLi")) {
				gameName = childElement.text();

			} else {
				Element gameElement = childElement.select(".gameList").get(0);
				Elements gameList = gameElement.children();

				int players = gameList.size();
				Element score = gameList.select(".point.own").get(0);

				Statistic statistic = DataBaseManager.getInstance().create(Statistic.class);
				statistic.setGameName(gameName);
				statistic.setGameFormat(score.parent().className());
				statistic.setNumberOfPlayers(players);
				statistic.setPlayedAt(DateUtils.getYesterday());
				statistic.setScore(score.text());
				statistic.setUser(user);
				statistic.save();
			}
		}
	}
}