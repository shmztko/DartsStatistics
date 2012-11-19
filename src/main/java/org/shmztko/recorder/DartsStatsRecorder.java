package org.shmztko.recorder;

import org.shmztko.model.User;
import org.shmztko.parser.DartsLiveStatParser;

public class DartsStatsRecorder {

	public void record(User user) {

		new DartsLiveStatParser(user).parse();



	}

}
