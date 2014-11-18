package Implementes;

import java.util.EmptyStackException;
import java.util.Iterator;



/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */

public class LinkedStack<Data> implements Stack<Data>, java.lang.Iterable<Data> {

	@Override
	public void push(Data d) {
		Node oldFirst = first;
		first = new Node();
		first.data = d;
		first.next = oldFirst;
		count++;

	}

	@Override
	public Data top() {
		if (!isEmpty()) {
			return first.data;
		}
		throw new EmptyStackException();
	}

	@Override
	public Data pop() {
		if (!isEmpty()) {
			Data data = first.data;
			first = first.next;
			count--;
			return data;
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

	private Node first = null;
	private int count = 0;

	private class Node {
		Data data;
		Node next;
	}

	private class IterateLinst<Data> implements java.util.Iterator<Data> {

		private Node temp = first;

		@Override
		public boolean hasNext() {
			return temp != null;
		}

		@Override
		public Data next() {
			Data data = (Data) temp.data;
			temp = temp.next;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
