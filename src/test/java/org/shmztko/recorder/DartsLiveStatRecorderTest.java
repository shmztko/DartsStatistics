package org.shmztko.recorder;

import java.util.Arrays;
import java.util.List;

import net.java.ao.Query;

import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.accessor.LocalDartsLiveStatAccessor;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.FixtureLoader;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.utils.DateUtils;

public class DartsLiveStatRecorderTest {

	private static DartsLiveStatRecorder testTarget;

	private static User user;

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataBaseManager.getInstance().migrateAll();

		user = new FixtureLoader().load(User.class).get("takewo");

		testTarget = new DartsLiveStatRecorder(user);
		// ローカルのHTMLファイルを参照するように差し替える。
		testTarget.setPageAccessor(new LocalDartsLiveStatAccessor());
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DataBaseManager.getInstance().delete(Statistic.class);
		DataBaseManager.getInstance().delete(User.class);
	}

	/**
	 * テストメソッド実行前に毎回実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * テストメソッド実行前に毎回実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_record() {
		testTarget.record();
		List<Statistic> stats = Arrays.asList(DataBaseManager.getInstance().find(Statistic.class, Query.select().where("user_id = ?", user.getID())));

		Statistic stat = stats.get(0);

		assertThat(stat.getGameName(), is(equalTo("701")));
		assertThat(stat.getGameFormat(), is(equalTo("singles")));
		assertThat(stat.getGameOrder(), is(equalTo(0)));
		assertThat(stat.getNumberOfPlayers(), is(equalTo(2)));
		assertThat(stat.getPlayedAt(), is(equalTo(DateUtils.getYesterday())));
		assertThat(stat.getScore(), is(equalTo("100.00")));
		assertThat(stat.getUser(), is(equalTo(user)));

	}

}
