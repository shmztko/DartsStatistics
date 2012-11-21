package org.shmztko.recorder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.User;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

public class DartsLivePageAccessorTest {

	static DartsLivePageAccessor testTarget;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		User[] users = DataBaseManager.getInstance().get(User.class);

		testTarget = new DartsLivePageAccessor(users[0]);
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
	public void test_getPlayDataPage() {
		String result = testTarget.getPlayDataPage();
		assertThat(result, is(not(nullValue())));
	}

}
