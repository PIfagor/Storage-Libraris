package Interfaces;
/**
 * 
 * @author Wise
 *
 * @param <Data>
 */
public interface Deque<Data> {

		public void addFirst(Data d);
		public void addLast(Data d);
		public Data getFirst ();
		public Data getLast ();
		public Data peekFirst();
		public Data peekLast ();
		public int size();
		public boolean isEmpty();
		public java.util.Iterator<Data> iterator();
		
}
