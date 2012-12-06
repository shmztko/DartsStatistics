package org.shmztko.exec;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.FixtureLoader;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;

/**
 * {@link Executer} に対応するテストクラスです。
 * @author ShimizuTakeo
 */
public class ExecuterTest {

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("http.proxyHost", "itfproxy.itfrontier.co.jp");
		System.setProperty("http.proxyPort", "8080");

		 DataBaseManager.getInstance().migrateAll();

		 new FixtureLoader().load(User.class);
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

	/** コマンドラインから実行される処理を通して実行しエラーがないか確認します */
	@Test
	public void test() {
		String[] args = {};
		Executer.main(args);
	}

}
