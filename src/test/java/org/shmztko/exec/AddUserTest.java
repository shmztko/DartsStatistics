package org.shmztko.exec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.shmztko.model.Award;
import org.shmztko.model.DB;
import org.shmztko.model.Record;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * {@link AddUser} のテストクラスです。
 * @author ShimizuTakeo
 */
public class AddUserTest {

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
		DB.open();
		try {
			Statistic.deleteAll();
			Award.deleteAll();
			Record.deleteAll();
			User.deleteAll();
		} finally {
			DB.close();
		}
	}

	/**
	 * 正常にユーザの追加が実行されることを確認
	 */
	@Test
	public void test_AddUser_Normal() {
		String email = "st0098@gmail.com";
		String cardName = "たけを＠紫推し";
		String loginUrl = "http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876";

		AddUser.main(new String[]{email, cardName, loginUrl});

		DB.open();
		try {
			User created = User.findFirst("");

			assertThat(created.getEmail(), is(equalTo(email)));
			assertThat(created.getCardName(), is(equalTo(cardName)));
			assertThat(created.getLoginUrl(), is(equalTo(loginUrl)));
		} finally {
			DB.close();
		}
	}


	/**
	 * 引数が足りない場合は、ユーザが作成されないことを確認。
	 */
	@Test
	public void test_AddUser_LessArguments() {
		String email = "st0098@gmail.com";
		String cardName = "たけを＠紫推し";

		AddUser.main(new String[]{email, cardName});

		DB.open();
		try {
			User created = User.findFirst("");
			assertThat(created, is(nullValue()));
		} finally {
			DB.close();
		}

	}
}
