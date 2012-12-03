package org.shmztko.accessor;

import org.shmztko.model.User;
/**
 * DartsLiveのカードページにアクセスするクラス
 * @author ShimizuTakeo
 */
public class DartsLivePageAccessor extends PageAccessor {

	/**
	 * このクラスのインスタンスが生成される時に呼び出されます。
	 * @param user アクセスするカードページの対象ユーザ
	 */
	public DartsLivePageAccessor(User user) {
		super(user);
	}

	/**
	 * プレイデータのページにアクセスし、ページ内容を取得します。
	 * @return ページ内容
	 */
	public String getPlayDataPage() {
		return getPageContent(DartsLivePages.PLAYDATA.getLocation());
	}

	/**
	 * DartsLiveのマイページで使われるURLを表すEnumです。
	 * @author ShimizuTakeo
	 */
	private enum DartsLivePages {
		/** プレイデータページ */
		PLAYDATA("http://card.dartslive.com/t/playdata.jsp");

		/** ページのURL */
		private String location;

		/**
		 * このEnumが生成される時に呼び出されます。
		 * @param location ページのURL
		 */
		private DartsLivePages(String location) {
			this.location = location;
		}

		/**
		 * @return ページのURL
		 */
		public String getLocation() {
			return location;
		}
	}
}
