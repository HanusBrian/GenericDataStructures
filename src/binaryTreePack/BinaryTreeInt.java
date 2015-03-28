package binaryTreePack;

public interface BinaryTreeInt <T extends Comparable<T>> {
	public void add(T info);
	public boolean remove(T info);
	public boolean find(T info);
	public int size();
	public int height();
	public void sort();
}
