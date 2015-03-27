package linkedList;

public interface List<T> {
	boolean add(T info);
	boolean delete(T info);
	boolean find(T info);
	int size();
	String toString();	
}
