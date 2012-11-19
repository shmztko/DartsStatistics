package org.shmztko.exec;

import java.sql.SQLException;

import org.shmztko.exceptions.ApplicationException;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.User;
import org.shmztko.recorder.DartsStatsRecorder;

public class Executer {

	public static void main(String[] args) {
		try {
			User[] users = DataBaseManager.getEntityManager().find(User.class);
			DartsStatsRecorder recorder = new DartsStatsRecorder();

			for (User user : users) {
				recorder.record(user);
			}

		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}
}