package org.shmztko.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * {@link DateUtils} に対応するテストクラスです。
 * @author ShimizuTakeo
 */
public class DateUtilsTest {

	/** 昨日が取得できるかどうかを確認します */
	@Test
	public void test_getYesterday() {
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE) - 1 , 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date yesterday = c.getTime();

		assertThat(DateUtils.getYesterday(), is(equalTo(yesterday)));
	}

}
