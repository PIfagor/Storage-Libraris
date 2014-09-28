package Implementes;

import java.util.EmptyStackException;
import Interfaces.Deque;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */
public class ArrayDeque<Data> implements Deque<Data>, java.lang.Iterable<Data> {

	public ArrayDeque(int size) {
		if (size > 0) {
			totalSize = size;
			data = (Data[]) new Object[totalSize];
		} else
			throw new EmptyStackException();
	};

	public ArrayDeque() {
		totalSize = defaultSize;
		data = (Data[]) new Object[totalSize];
	}

	@Override
	public void addFirst(Data d) {
		if(bottom<=0)
			enlargeReverse();
			data[bottom--] = d;
	}

	@Override
	public void addLast(Data d) {
		if (needEnlarge()) {
			enlarge();
		}
		data[++currentSize+pocket] = d;

	}

	@Override
	public Data peekFirst() {
		if (!isEmpty()) {
			return data[bottom + 1];
		}
		throw new EmptyStackException();
	}

	@Override
	public Data peekLast() {
		if (!isEmpty()) {
			return data[currentSize];
		}
		throw new EmptyStackException();
	}

	@Override
	public Data getFirst() {

		if (!isEmpty()) {
			if (needCompress()) {
				compress();
			}
			return data[++bottom];
		}
		throw new EmptyStackException();
	}

	@Override
	public Data getLast() {
		if (!isEmpty()) {
			return data[currentSize--];
		}
		throw new EmptyStackException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize - bottom;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == bottom;
	}

	private Data[] data;
	private int defaultSize = 21;
	private int totalSize = 0;
	private int bottom = -1;
	private int currentSize = -1;
	private boolean elraged = false;
	private int pocket = 0;
	
	private void enlargeReverse()
	{
		pocket = 3;
		Data[] temp = (Data[]) new Object[totalSize+pocket];
		for (int i = 0; i <= currentSize; i++) {
			temp[i+pocket] = data[bottom + i];
		}
		bottom = pocket;
		currentSize += pocket;
		data = temp;
	}
	
	private void enlarge() {
		totalSize *= 2;
		pocket =0;
		if (bottom < 0)
			bottom++;
		currentSize -= bottom;
		Data[] temp = (Data[]) new Object[totalSize];
		;
		for (int i = 0; i <= currentSize; i++) {
			temp[i] = data[bottom + i];
		}
		bottom = -1;
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
		// if(bottom<0) bottom++;
		currentSize -= bottom;
		Data[] temp = (Data[]) new Object[totalSize];
		;
		for (int i = 0; i <= currentSize; i++) {
			temp[i] = data[i + bottom + 1];
		}
		bottom = -1;
		elraged = false;
		data = temp;
	}

	private boolean needCompress() {
		if (totalSize / 4 == (currentSize - bottom) && elraged)
			return true;

		return false;
	}

	private class IterateArray<Data> implements java.util.Iterator<Data> {

		private int bot = bottom;
		private int current = currentSize+pocket;

		@Override
		public boolean hasNext() {
			return current > bot;
		}

		@Override
		public Data next() {
			return (Data) data[++bot];
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
