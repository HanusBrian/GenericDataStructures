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
	public boolean remove(T info) {
		
		Node<T> delPointer = root;
		
		//Find the node that will be deleted, if no node exists with the info return false
		while(delPointer.getInfo() != info){
			if(delPointer.getInfo().compareTo(info) > 0){
				delPointer = delPointer.getLeft();
			}else if(delPointer.getInfo().compareTo(info) < 0){
				delPointer = delPointer.getRight();
			}
			if(delPointer == null){
				return false;
			}
		}
		
		//Heir to the spot should be the next in order so go one node right then all the way left
		Node<T> heirPointer = delPointer;
		Node<T> heirParent = delPointer;
		int count = 0;
		boolean isLeft = true;
		
		if(heirPointer.getRight() != null){
			heirPointer = heirPointer.getRight();
			isLeft = false;
			
			while(heirPointer.getLeft() != null){
				
				if(count == 0){
					heirParent = heirParent.getRight();
					isLeft = true;
					count++;
				}else{
					heirParent = heirParent.getLeft();
				}
				heirPointer = heirPointer.getLeft();
			}
		//If the right side of the tree is empty then the heir belongs to the next lowest number
		}else if(heirPointer.getLeft() != null){
			heirPointer = heirPointer.getLeft();
			isLeft = true;
			while(heirPointer.getRight() != null){
				if(count == 0){
					heirParent = heirParent.getLeft();
					isLeft = false;
					count++;
				}else{
					heirParent = heirParent.getRight();
				}
				heirPointer = heirPointer.getRight();
			}
		}else{
			root = null;
		}
		//Pointer is now pointing to the heir, cut and paste that bad boy into his throne
		delPointer.setInfo(heirPointer.getInfo());
		
		if(root != null)
			if(isLeft){
				heirParent.setLeft(null);
			}else{
				heirParent.setRight(null);
			}
		
		return true;
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
