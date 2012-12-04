package org.shmztko.model;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

public class FixtureLoaderTest {

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataBaseManager.getInstance().migrateAll();

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

	/** ymlファイルから値が読み込めるかどうかを確認します。*/
	@Test
	public void test_load() {
		Map<String, User> users = new FixtureLoader().load(User.class);
		User user = users.get("takewo");

		assertThat(user.getCardName(), is(equalTo("たけを＠紫推し")));
		assertThat(user.getLoginUrl(), is(equalTo("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876")));
		assertThat(user.getEmail(), is(equalTo("st0098@gmail.com")));
	}
}
