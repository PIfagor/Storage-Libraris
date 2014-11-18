package Implementes;

import java.util.EmptyStackException;



/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */

public class ArrayStack<Data> implements Stack<Data>, java.lang.Iterable<Data> {

	public ArrayStack(int size) {
		if (size > 0) {
			totalSize = size;
			data = (Data[]) new Object[totalSize];
		} else
			throw new EmptyStackException();
	};

	public ArrayStack() {
		totalSize = defaultSize;
		data = (Data[]) new Object[totalSize];
	}

	@Override
	public void push(Data d) {
		if (needEnlarge()) {
			enlarge();
		}
		data[++currentSize] = d;
	}

	@Override
	public Data top() {
		if (!isEmpty()) {

			return data[currentSize - 1];
		}
		throw new EmptyStackException();
	}

	@Override
	public Data pop() {
		if (!isEmpty()) {
			if (needCompress()) {
				compress();
			}
			return data[--currentSize + 1];
		}
		throw new EmptyStackException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == -1;
	}

	private Data[] data;
	private int defaultSize = 21;
	private int totalSize = 0;
	private int currentSize = -1;
	private boolean elraged = false;

	private void enlarge() {
		totalSize *= 2;
		Data[] temp = (Data[]) new Object[totalSize];
		;
		for (int i = 0; i <= currentSize; i++) {
			temp[i] = data[i];
		}
		elraged = true;
		data = temp;
	};

	private boolean needEnlarge() {
		if (totalSize * 3 / 4 == currentSize)
			return true;
		return false;
	}

	private void compress() {
		totalSize *= 0.75;
		Data[] temp = (Data[]) new Object[totalSize];
		;
		for (int i = 0; i <= currentSize; i++) {
			temp[i] = data[i];
		}
		elraged = false;
		data = temp;
	}

	private boolean needCompress() {
		if (totalSize / 4 == currentSize && elraged)
			return true;

		return false;
	}

	private class IterateArray<Data> implements java.util.Iterator<Data> {

		private int current = currentSize;

		@Override
		public boolean hasNext() {
			return current > 0;
		}

		@Override
		public Data next() {
			return (Data) data[--current];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public java.util.Iterator<Data> iterator() {
		return new IterateArray();
	}
}
