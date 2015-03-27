package stackPack;

public interface StackInt<T> {
	public void push(T info);
	public T pop() throws StackException;
	public T peek();
	public boolean isEmpty();
}
