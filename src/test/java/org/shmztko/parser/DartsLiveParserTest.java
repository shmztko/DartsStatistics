package org.shmztko.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.shmztko.accessor.LocalDartsLiveStatAccessor;
import org.shmztko.model.Statistic;
import org.shmztko.utils.DateUtils;

public class DartsLiveParserTest {

	private DartsLiveParser testTarget;

	@Test
	public void testGetYesterdayStats() {
		testTarget = new DartsLiveParser(new LocalDartsLiveStatAccessor());
		List<Statistic> stats = testTarget.getYesterdayStats();
		Statistic stat = stats.get(0);

		assertThat(stat.getGameName(), is(equalTo("701")));
		assertThat(stat.getGameFormat(), is(equalTo("singles")));
		assertThat(stat.getGameOrder(), is(equalTo(0)));
		assertThat(stat.getNumberOfPlayers(), is(equalTo(2)));
		assertThat(stat.getPlayedAt(), is(equalTo(DateUtils.getYesterday())));
		assertThat(stat.getScore(), is(equalTo("100.00")));
	}

}
