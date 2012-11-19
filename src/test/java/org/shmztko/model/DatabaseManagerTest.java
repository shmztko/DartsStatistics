package org.shmztko.model;

import java.sql.SQLException;

import org.hsqldb.Server;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseManagerTest {

	private static org.hsqldb.Server server;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		server = new Server();
		server.setDatabaseName(0, "test");
		server.setDatabasePath(0, "mem:test;sql.enforce_strict_size=true");
		server.setLogWriter(null);
		server.setErrWriter(null);
		server.start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        server.stop();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
/*
		EntityManager em = new EntityManager("jdbc:hsqldb:hsql://localhost/test", "sa", "");
        em.migrate(User.class);

        User p1 = em.create(User.class);
        p1.setCardName("Thome");
        p1.setEmail("thome@example.com");
        p1.save();

        User p2 = em.create(User.class);
        p2.setName("Mick");
        p2.setEmail("mick@example.com");
        p2.save();

        for(User p : em.find(User.class)) {
            System.out.println(p.getName() + ":" + p.getEmail());
        }
*/
	}

}
