package com.gamevm.utils.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AttributeFilter extends ElementFilter {

	private String attributeName;
	private String attributeValue;
	
	public AttributeFilter(String attributeName, String attributeValue) {
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}
	
	@Override
	public boolean passes(Node n) {
		return ((Element)n).getAttribute(attributeName).equals(attributeValue);
	}
	
}
