package org.shmztko.recorder;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.utils.DateUtils;

public class DartsLiveStatRecorderTest {

	private static DartsLiveRecorder testTarget;

	private static User user;

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		User user = new User();
		user.setCardName("たけを＠紫推し");
		user.setEmail("st0098@gmail.com");
		user.setLoginUrl("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876");
		user.saveIt();

		testTarget = new DartsLiveRecorder();
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Statistic.deleteAll();
		User.deleteAll();
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
		testTarget.record(user);
		
		List<Statistic> stats = Statistic.where("user_id = ?", user.getId());

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
