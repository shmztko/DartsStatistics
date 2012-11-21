package org.shmztko.parser;

import net.java.ao.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.Statistic;
import org.shmztko.model.User;

import static org.junit.Assert.*;

public class DartsLiveStatParserTest {

	static User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("http.proxyHost", "itfproxy.itfrontier.co.jp");
		System.setProperty("http.proxyPort", "8080");

		DataBaseManager.getInstance().migrate(User.class, Statistic.class);

		User[] users = DataBaseManager.getInstance().find(User.class, Query.select().where("email = ?", "st0098@gmail.com"));
		if (users.length > 0) {
			user = users[0];
		} else {
			user = DataBaseManager.getInstance().create(User.class);
			user.setCardName("たけを＠紫推し");
			user.setLoginUrl("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876");
			user.setEmail("st0098@gmail.com");
			user.save();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {


	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testParse() {
		fail("Not yet implemented.");
	}

}
