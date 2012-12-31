package org.shmztko.common;

import java.util.logging.Logger;

public class LogFactory {

	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	public static Logger getLogger(String loggerName) {
		return Logger.getLogger(loggerName);
	}
}


