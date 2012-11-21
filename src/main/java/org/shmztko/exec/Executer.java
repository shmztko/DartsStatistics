package org.shmztko.exec;

import org.shmztko.model.DataBaseManager;
import org.shmztko.model.User;
import org.shmztko.recorder.DartsStatsRecorder;

public class Executer {

	public static void main(String[] args) {
		User[] users = DataBaseManager.getInstance().find(User.class);
		DartsStatsRecorder recorder = new DartsStatsRecorder();

		for (User user : users) {
			recorder.record(user);
		}
	}
}