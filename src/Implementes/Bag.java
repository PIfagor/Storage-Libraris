package Implementes;

import java.util.Iterator;

import Interfaces.Stack;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */

public class Bag<Data> implements java.lang.Iterable<Data> {
	private Stack st;

	public Bag(int mode) {
		if (mode == 0)
			st = new ArrayStack<>();
		else
			st = new LinkedStack<>();
	}

	public void add(Data d) {
		st.push(d);
	}

	public int size() {
		return st.size();
	}

	@Override
	public Iterator<Data> iterator() {

		return st.iterator();
	}

}
