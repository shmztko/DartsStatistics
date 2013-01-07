package org.shmztko.exec;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.model.Award;
import org.shmztko.model.DB;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;

/**
 * {@link Record} に対応するテストクラスです。
 * @author ShimizuTakeo
 */
public class RecordTest {

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DB.open();
		try {
			User user = new User();
			user.setCardName("たけを＠紫推し");
			user.setEmail("st0098@gmail.com");
			user.setLoginUrl("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876");
			user.saveIt();
		} finally {
			DB.close();
		}
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DB.open();
		try {
			Statistic.deleteAll();
			Award.deleteAll();
			org.shmztko.model.Record.deleteAll();
			User.deleteAll();
		} finally {
			DB.close();
		}
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
		Record.main(args);
	}

}
