package org.shmztko.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DateUtilsTest {

	@Test
	public void test_getYesterday() {
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE) - 1 , 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date yesterday = c.getTime();

		assertThat(DateUtils.getYesterday(), is(equalTo(yesterday)));
	}

}
