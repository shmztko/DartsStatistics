package org.shmztko.parser;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.accessor.LocalDartsLiveStatAccessor;
import org.shmztko.model.DB;
import org.shmztko.model.Statistic;
import org.shmztko.utils.DateUtils;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * {@link DartsLiveParser} のテストクラス
 * @author ShimizuTakeo
 */
public class DartsLiveParserTest {

	/** テスト対象 */
	private DartsLiveParser testTarget;

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DB.open();
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DB.close();
	}

	/**
	 * ローカルファイルから昨日の成績をパースすることができるかを確認
	 */
	@Test
	public void test_GetYesterdayStats() {
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
