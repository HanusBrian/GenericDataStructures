package binaryTreePack;

public class Node<T extends Comparable<T>> implements Comparable<T> {
	private T info;
	private Node<T> left;
	private Node<T> right;
	
	public Node(){}
	
	public Node(T info){
		this.setInfo(info);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public int compareTo(T info){
		int cmp = this.getInfo().compareTo(info);
		return cmp;
	}
	
	@Override
	public String toString(){
		String s = "" + getInfo();
		return s;
	}
	
}
