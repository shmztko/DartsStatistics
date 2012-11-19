package org.shmztko.parser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DartsLiveStatParserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("http.proxyHost", "itfproxy.itfrontier.co.jp");
		System.setProperty("http.proxyPort", "8080");
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
		DartsLiveStatParser parser = new DartsLiveStatParser();
		parser.setCardPageURL("http://card.dartslive.com/t/top.jsp?i=559300205543375&n=2124119876");
		parser.parse();
		parser.setCardPageURL("http://card.dartslive.com/t/play/index.jsp");
		parser.parse();
	}

}
