package com.gamevm.utils.xml;

import org.w3c.dom.Node;

public interface Filter {

	public boolean passes(Node n);
	
}
