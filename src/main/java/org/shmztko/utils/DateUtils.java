package org.shmztko.utils;

import java.util.Calendar;
import java.util.Date;
/**
 * 日付関連のユーティリティクラスです。
 * @author ShimizuTakeo
 */
public class DateUtils {

	/**
	 * 昨日の日付を取得します。
	 * @return 昨日の日付
	 */
	public static Date getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE) - 1, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
