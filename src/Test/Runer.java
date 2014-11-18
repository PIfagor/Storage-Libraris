package Test;

import java.util.LinkedList;



import Implementes.ArrayDeque;
import Implementes.ArrayQueue;
import Implementes.LinkedQueue;

/**
 * 
 * @author Wise
 * 
 */
public class Runer {

	/**
	 * @param args
	 * @author Wise
	 */
	public static void main(String[] args) {

//		ArrayStack<Integer> first = new ArrayStack<Integer>(1);
//		for (int i = 0; i < 100; i++) {
//			first.push(i * i);
//		}
//		for (Integer m : first) {
//			System.out.println(m);
//		}
//		for (int i = 0; i < 100; i++) {
//			System.out.println(first.pop());
//		}
//
//		LinkedStack<Integer> second = new LinkedStack<Integer>();
//		for (int i = 0; i < 10; i++) {
//			second.push(i * i);
//		}
//		for (Integer m : second) {
//			System.out.println(m);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(second.pop());
//		}
//
//		ArrayQueue<Integer> three = new ArrayQueue<Integer>(2);
//		for (int i = 0; i < 10; i++) {
//			three.put(i * i);
//		}
//		for (Integer m : three) {
//			System.out.println(m);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(three.get());
//		}
//
//		LinkedQueue<Integer> four = new LinkedQueue<Integer>();
//		for (int i = 0; i < 10; i++) {
//			four.put(i * i);
//		}
//		for (Integer m : four) {
//			System.out.println(m);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(four.get());
//		}
//
//		Bag<Integer> five = new Bag<Integer>(0);
//		for (int i = 0; i < 10; i++) {
//			five.add(i * i);
//		}
//		for (Integer m : five) {
//			System.out.println(m);
//		}
//		Bag<Integer> fivePlus = new Bag<Integer>(1);
//		for (int i = 0; i < 10; i++) {
//			fivePlus.add(i * i);
//		}
//		for (Integer m : fivePlus) {
//			System.out.println(m);
//		}
		
		ArrayDeque<Integer> six = new ArrayDeque<Integer>();
		for (int i = 0; i < 5; i++) {
			six.addLast(i * i);
		}
			
		for (Integer m : six) {
			System.out.println(m);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(six.getLast());
		}
		for (int i = 0; i < 5; i++) {
			six.addFirst(i * i);
		}
			
		for (Integer m : six) {
			System.out.println(m);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(six.getLast());
		}
	}
};
