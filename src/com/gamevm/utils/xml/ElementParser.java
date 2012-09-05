package com.gamevm.utils.xml;

import org.w3c.dom.Element;

public interface ElementParser<T> {
	
	T parse(Element e);

}
