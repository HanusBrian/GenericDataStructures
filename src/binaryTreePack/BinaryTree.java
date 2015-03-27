package binaryTreePack;

public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInt<T> {
	Node<T> root;

	@Override
	public void add(T info){
		root = add(root, info);
	}
	private Node<T> add(Node<T> n, T info) {
		if(n == null){
			return new Node<T>(info);
		}
		int cmp = info.compareTo(n.getInfo());
		if(cmp <= 0){
			n.setLeft(add(n.getLeft(), info));
		}else if(cmp > 0){
			n.setRight(add(n.getRight(), info));
		}
		return n;
	}

	@Override
	public void remove(T info) {
		Node<T> pointer = root;
		if(pointer.getInfo() == info){
		
		}
	}

	@Override
	public boolean find(T info) {

		Node<T> pointer = root;
		
		while(pointer != null){
			int cmp = info.compareTo(pointer.getInfo());
			
			if(cmp == 0){
				return true;
			}else if(cmp < 0){
				pointer = pointer.getLeft();
			}else{
				pointer = pointer.getRight();
			}
			
		}
		return false;
	}

	@Override
	public int size(){
		return size(root);
	}
	
	public int size(Node<T> n) {
		if(n == null){
			return 0;
		}
		return 1 + size(n.getRight()) + size(n.getLeft());
	}
	

	@Override
	public int height(){
		return height(root);
	}
	
	public int height(Node<T> n) {
		if(n == null){
			return 0;
		}
		return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
	}
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	
	public void displayInOrder(){
		displayInOrder(this.root);
	}
	
	private void displayInOrder(Node<T> n) {		
		
		if(n != null){
			displayInOrder(n.getLeft());
			System.out.println(n);
			displayInOrder(n.getRight());
		}
	}
	
	public void displayPreOrder(){
		displayPreOrder(root);
	}
	
	private void displayPreOrder(Node<T> n) {		
		
		if(n != null){
			System.out.println(n);
			displayPreOrder(n.getLeft());
			displayPreOrder(n.getRight());
		}
	}
	
	public void displayPostOrder(){
		displayPostOrder(root);
	}
	
	private void displayPostOrder(Node<T> n) {		
		
		if(n != null){
			displayPostOrder(n.getLeft());
			displayPostOrder(n.getRight());
			System.out.println(n);
		}
	}
	
	@Override
	public String toString(){
		String s = "This tree has a root of " + root.getInfo();
		return s;
	}

}
