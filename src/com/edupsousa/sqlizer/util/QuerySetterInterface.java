package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public interface QuerySetterInterface {
	public String getSql(LinkedHashMap<String, String> fields);
}
