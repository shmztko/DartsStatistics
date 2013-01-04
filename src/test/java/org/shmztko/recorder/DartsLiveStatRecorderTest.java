package org.shmztko.recorder;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.accessor.LocalDartsLiveStatAccessor;
import org.shmztko.model.DB;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;
import org.shmztko.utils.DateUtils;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * {@link DartsLiveRecorder} のテストクラス
 * @author ShimizuTakeo
 */
public class DartsLiveStatRecorderTest {

	/** テスト対象 */
	private static DartsLiveRecorder testTarget;

	/** テスト用ユーザ情報 */
	private static User user;

	/**
	 * テストクラス生成前に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DB.open();
		user = new User();
		user.setCardName("たけを＠紫推し");
		user.setEmail("st0098@gmail.com");
		user.setLoginUrl("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876");
		user.saveIt();
		DB.close();

		testTarget = new DartsLiveRecorder();
	}

	/**
	 * テストクラス生成後に一度だけ実行される
	 * @throws Exception 何かしらの例外が発生した場合
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DB.open();
		Statistic.deleteAll();
		User.deleteAll();
		DB.close();
	}

	/**
	 * ローカルのHTMLファイルを記録し、その結果がちゃんと格納されているかを確認する。
	 */
	@Test
	public void test_record() {
		DB.open();
		try {
			// ローカル読み込み用のPageAccessorにする
			testTarget.setPageAccessor(new LocalDartsLiveStatAccessor());
			testTarget.record(user);

			List<Statistic> stats = user.getAll(Statistic.class);

			Statistic stat = stats.get(0);

			assertThat(stat.getGameName(), is(equalTo("701")));
			assertThat(stat.getGameFormat(), is(equalTo("singles")));
			assertThat(stat.getGameOrder(), is(equalTo(0)));
			assertThat(stat.getNumberOfPlayers(), is(equalTo(2)));
			assertThat(stat.getPlayedAt(), is(equalTo(DateUtils.getYesterday())));
			assertThat(stat.getScore(), is(equalTo("100.00")));
		} finally {
			DB.close();
		}
	}

}
