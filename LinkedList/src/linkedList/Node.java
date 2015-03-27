package linkedList;

public class Node {
	private String info;
	private Node node;
	
	
	public Node(String info){
		this.info = info;
		node = null;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
	
	public void setLink(Node node){
		this.node = node;
	}
	
	public void setLink(){
		this.node = null;
	}
	
	public Node getLink(){
		return node;
	}
	
}
