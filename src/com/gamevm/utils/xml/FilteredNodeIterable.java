package com.gamevm.utils.xml;

import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FilteredNodeIterable<T extends Node> implements Iterable<T> {

	private Filter filter;
	private NodeList nodes;

	protected class FilteredNodeIterator implements Iterator<T> {

		private int i;

		public FilteredNodeIterator() {
			i = -1;
		}

		@Override
		public boolean hasNext() {
			int tmp = i;
			while (!filter.passes(nodes.item(++i)))
				;
			boolean result = (i < nodes.getLength() - 1);
			i = tmp;
			return result;
		}

		@Override
		public T next() {
			while (!filter.passes(nodes.item(++i)))
				;
			return (T) nodes.item(i);
		}

		@Override
		public void remove() {
			// ignore
		}

	}

	public FilteredNodeIterable(NodeList list, Filter filter) {
		this.filter = filter;
		this.nodes = list;
	}

	@Override
	public Iterator<T> iterator() {
		return new FilteredNodeIterator();
	}

}
