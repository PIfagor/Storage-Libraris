package Implementes;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Random;


import Interfaces.RandomQueue;

public class RandomLinkedQueue<Data> implements RandomQueue<Data>, java.lang.Iterable<Data>{
	
	
	public RandomLinkedQueue() {
		this.count = 0;
		this.randomGenerator = new Random();;
	}

	@Override
	public void enqueue(Data d) {
		
		
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
	public Data dequeue() {
		if (!isEmpty()) {
			
			int rand = randomGenerator.nextInt(count);
			Node reserve = first;
			Node temp = reserve;
			Node nextTemp = temp.next;
			while(rand--!=0)
			{
				temp = temp.next;
				nextTemp  = temp.next;
			}
			
			
			Data item = nextTemp.data;
			temp.next = nextTemp.next;
			
			first= reserve;
			count--;
			if (isEmpty())
				last = null;
			return item;
		}
		throw new EmptyStackException();
	}

	@Override
	public Data get() {
		if (!isEmpty()) {
			int rand = randomGenerator.nextInt(count);
			Node temp = first;
			while(rand--!=0)
			temp = temp.next;
			return temp.data;
					
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
	private int count;
	private Random randomGenerator ;
	
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
