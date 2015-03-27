package queuePack;

public interface QueueInt<T> {
	public void enqueue(T info);
	public T dequeue();
	public boolean isEmpty();
}
