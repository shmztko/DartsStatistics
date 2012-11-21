package org.shmztko.model;

import java.sql.SQLException;
import java.util.ResourceBundle;

import net.java.ao.DBParam;
import net.java.ao.DatabaseProvider;
import net.java.ao.Entity;
import net.java.ao.EntityManager;
import net.java.ao.Query;
import net.java.ao.schema.UnderscoreFieldNameConverter;
import net.java.ao.schema.UnderscoreTableNameConverter;

import org.shmztko.exceptions.ApplicationException;

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
		manager.setFieldNameConverter(new UnderscoreFieldNameConverter(false));
		manager.setTableNameConverter(new UnderscoreTableNameConverter(false));
	}

	public static EntityManager getEntityManager() {
		return INSTANCE.manager;
	}

	public static DataBaseManager getInstance() {
		return INSTANCE;
	}

	public <T extends Entity> T create(Class<T> entity, DBParam ...dbParams) {
		try {
			return manager.create(entity, dbParams);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to create records. -> " + entity.toString(), e);
		}
	}

	public void migrate(Class<? extends Entity> ... entities) {
		try {
			manager.migrate(entities);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to migrate. -> " + entities.toString(), e);
		}
	}

	public <T extends Entity> T[] find(Class<T> entity, Query query) {
		try {
			return manager.find(entity, query);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to find records. -> " + entity.toString(), e);
		}
	}

	public <T extends Entity> T[] find(Class<T> entity) {
		try {
			return manager.find(entity);
		} catch (SQLException e) {
			throw new ApplicationException("Failed to find records. -> " + entity.toString(), e);
		}
	}

	public <T extends Entity> T[] get(Class<T> entity) {
		return manager.get(entity);
	}
}
