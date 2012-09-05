package com.gamevm.utils.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementFilter implements Filter {
	
	public static final ElementFilter FILTER = new ElementFilter();

	@Override
	public boolean passes(Node n) {
		return n instanceof Element;
	}

}
