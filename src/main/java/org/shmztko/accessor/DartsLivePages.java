package org.shmztko.accessor;

/**
 * DartsLiveのユーザページの場所を表す列挙型です。
 * @author ShimizuTakeo
 */
public enum DartsLivePages {

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