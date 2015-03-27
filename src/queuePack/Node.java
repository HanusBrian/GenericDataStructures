package queuePack;

public class Node<T> {
	private T info;
	private Node<T> node;
	
	
	public Node(T info){
		this.info = info;
		node = null;
	}
	
	public void setInfo(T info){
		this.info = info;
	}
	
	public T getInfo(){
		return info;
	}
	
	public void setLink(Node<T> node){
		this.node = node;
	}
	
	public void setLink(){
		this.node = null;
	}
	
	public Node<T> getLink(){
		return node;
	}
	
}
