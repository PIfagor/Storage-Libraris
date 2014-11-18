package Interfaces;

public interface RandomQueue<Data>  {
	 public boolean isEmpty();
	 public void enqueue(Data data);
	 public Data dequeue();
	 public Data get();
	 public int size();
	 
}
