package org.shmztko.accessor;

import org.shmztko.model.User;

public class DartsLivePageAccessor extends PageAccessor {

	public DartsLivePageAccessor(User user) {
		super(user);
	}

	public String getPlayDataPage() {
		return getPageContent(DartsLivePages.PLAYDATA.getLocation());
	}

	private enum DartsLivePages {
		PLAYDATA("http://card.dartslive.com/t/playdata.jsp");

		private String location;

		private DartsLivePages(String location) {
			this.location = location;
		}

		public String getLocation() {
			return location;
		}
	}
}
