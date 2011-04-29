package com.gamevm.utils.commandline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arguments {
	
	private Map<String, String> namedValues;
	
	private String[] unnamedValues;
	
	public Arguments(String[] args) {
		namedValues = new HashMap<String, String>();
		List<String> unnamed = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				namedValues.put(args[i], args[++i]);
			} else {
				unnamed.add(args[i]);
			}
		}
		unnamedValues = unnamed.toArray(new String[unnamed.size()]);
	}
	
	public String getValue(String shortName, String longName) {
		String v = namedValues.get("-" + shortName);
		if (v == null) {
			v = namedValues.get("--" + longName);
		}
		return v;
	}
	
	public String[] getUnnamedValues() {
		return unnamedValues;
	}
}
