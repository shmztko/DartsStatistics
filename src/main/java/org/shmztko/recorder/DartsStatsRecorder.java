package org.shmztko.recorder;

import org.shmztko.model.User;

public class DartsStatsRecorder {

	public void record(User user) {
		DartsLiveStatRecorder dlRecorder = new DartsLiveStatRecorder(user);
		dlRecorder.record();
	}
}
