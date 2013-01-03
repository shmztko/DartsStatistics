package org.shmztko.model;

import java.util.HashMap;
import java.util.Map;

public class Model extends org.javalite.activejdbc.Model {

	private Map<String, Object> inMemoryProperties = new HashMap<String, Object>();

	protected Object getValue(String key) {
		Object dbValue = get(key);
		if (dbValue != null) {
			return dbValue;
		} else {
			return inMemoryProperties.get(key);
		}
	}
	
	protected void setValue(String key, Object value) {
		inMemoryProperties.put(key, value);
		set(key, value);
	}
}
