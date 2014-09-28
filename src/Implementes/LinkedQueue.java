package Implementes;

import java.util.EmptyStackException;
import java.util.Iterator;

import Interfaces.Queue;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */

public class LinkedQueue<Data> implements Queue<Data>, java.lang.Iterable<Data> {

	@Override
	public void put(Data d) {
		Node oldLast = last;
		last = new Node();
		last.data = d;
		last.next = null;
		count++;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;

	}

	@Override
	public Data front() {
		if (!isEmpty()) {
			return last.data;
		}
		throw new EmptyStackException();
	}

	@Override
	public Data get() {
		if (!isEmpty()) {
			Data item = first.data;
			first = first.next;
			count--;
			if (isEmpty())
				last = null;
			return item;
		}
		throw new EmptyStackException();
	}

	@Override
	public int size() {
		return count;

	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<Data> iterator() {
		// TODO Auto-generated method stub
		return new IterateLinst();
	}

	private Node first, last;
	private int count = 0;

	private class Node {
		Data data;
		Node next;
	}

	private class IterateLinst<Data> implements java.util.Iterator<Data> {

		private Node f = first;
		private Node l = last;

		@Override
		public boolean hasNext() {
			return f != l.next;
		}

		@Override
		public Data next() {
			Data data = (Data) f.data;
			f = f.next;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
