package com.gamevm.utils.xml;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class XML {
	
	public static Iterable<Element> getChildren(Element e) {
		return new FilteredNodeIterable<Element>(e.getChildNodes(), ElementFilter.FILTER);
	}
	
	public static Iterable<Element> getChildren(Element e, String tagName) {
		return new FilteredNodeIterable<Element>(e.getChildNodes(), new ElementNameFilter(tagName));
	}
	
	public static Element getChild(Element e, String tagName) {
		return getChildren(e, tagName).iterator().next();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] parseChildren(Element e, ElementParser<T> p, Class<T> componentType) {
		T[] objects = (T[])Array.newInstance(componentType, e.getChildNodes().getLength());
		int i = 0;
		for (Element c : XML.getChildren(e)) {
			objects[i++] = p.parse(c);
		}
		return objects;
	}
	
	public static <T> List<T> parse(Iterable<Element> elements, ElementParser<T> p) {
		List<T> result = new ArrayList<T>();
		for (Element c : elements) {
			result.add(p.parse(c));
		}
		return result;
	}

}
