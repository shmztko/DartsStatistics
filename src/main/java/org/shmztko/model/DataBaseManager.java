package org.shmztko.model;

import java.util.ResourceBundle;

import net.java.ao.DatabaseProvider;
import net.java.ao.EntityManager;

public class DataBaseManager {

	private EntityManager manager;

	private static DataBaseManager INSTANCE = new DataBaseManager();

	private DataBaseManager() {
		ResourceBundle bundle = ResourceBundle.getBundle("darts-statistics");
		manager = new EntityManager(DatabaseProvider.getInstance(
				bundle.getString("db.url"),
				bundle.getString("db.username"),
				bundle.getString("db.password")
		));
	}

	public static EntityManager getEntityManager() {
		return INSTANCE.manager;
	}
}
