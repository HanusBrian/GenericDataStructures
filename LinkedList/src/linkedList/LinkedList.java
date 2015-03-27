package linkedList;

public class LinkedList implements List {
	
	public Node root;
	public String name;
	
	public LinkedList(){
		
	}
	
	public LinkedList(String name){
		this.name = name;
		root = null;
	}
	
	@Override
	public boolean add(String info){

		if(this.root == null){
			root = new Node(info);
			return true;
		}	
		
		Node node = root;
		
		for(int i = 0; i < this.size()-1; i++)
			node = node.getLink();
		node.setLink(new Node(info));
		
		return true;
	}
	
	@Override
	public boolean delete(String info){
		Node pointer = root;
		Node trail = root;
		int count = 0;
		while(pointer != null){
			if(pointer.getInfo().equalsIgnoreCase(info)){
				if(pointer == root){
					root = pointer.getLink();
					return true;
				}else{
					trail.setLink(pointer.getLink());
					return true;
				}
			}
			if(count != 0){
				trail = trail.getLink();
			}
			pointer = pointer.getLink();
			count++;
		}
		return false;
	}
	
	public boolean delete(int pos){
		Node pointer = root;
		for(int i = pos - 1; i >= 0; i--){
			pointer = pointer.getLink();
		}
		if(pointer.getLink() != null){
			pointer.setInfo(pointer.getLink().getInfo());
			pointer.setLink(pointer.getLink());
		}else{
			pointer = root;
			for(int i = pos - 2; i >= 0; i--){
				pointer = pointer.getLink();
			}
			pointer.setLink();
		}
		return true;
	}
	
	public boolean delete(){
		root = root.getLink();
		return true;
	}
	
	public void clear(){
		root = null;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public int size(){
		int count = 0;
		Node node;
		node = root;
		while(node != null){
			count++;
			node = node.getLink();
		}
		return count;
	}
	
	@Override
	public boolean find(String s){
		Node node;
		node = root;
		while(node != null){
			if(node.getInfo().equalsIgnoreCase(s))
				return true;
			node = node.getLink();
		}
		return false;	
	}
	
	@Override
	public String toString(){
		String s = name + ": \n\n";
		Node node = root;
		int count = 0;
		while(node != null){
			count ++;
			s = s + count + ": " + node.getInfo() + "\n";
			node = node.getLink();
		}
		return s;
	}
}
