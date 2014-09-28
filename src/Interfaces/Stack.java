package Interfaces;

/**
 * 
 * @author Wise
 * 
 * @param <Data>
 */
public interface Stack<Data> {

	public void push(Data d);

	public Data top();

	public Data pop();

	public int size();

	public boolean isEmpty();

	public java.util.Iterator<Data> iterator();
}
