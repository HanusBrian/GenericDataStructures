package queuePack;

public class Queue<T> implements QueueInt<T>{
	Node<T> head;
	Node<T> tail;
	
	@Override
	public void enqueue(T info) {
		Node<T> temp = new Node<>(info);
		temp.setLink(tail);
		temp = tail;
		if(isEmpty()){
			head = temp;
		}
	}

	@Override
	public T dequeue() {
		Node<T> temp = head;
		head = head.getLink();
		return temp.getInfo();
	}

	@Override
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}
	
}
