package com.gamevm.utils.xml;

import org.w3c.dom.Node;

public class ElementNameFilter extends ElementFilter {
	
	private String name;
	
	public ElementNameFilter(String tagName) {
		this.name = tagName;
	}
	
	@Override
	public boolean passes(Node n) {
		return super.passes(n) && n.getLocalName().equals(name);
	}

}
