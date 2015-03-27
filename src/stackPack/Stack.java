package stackPack;

public class Stack<T> implements StackInt<T> {
	Node<T> top;
	
	@Override
	public void push(T info) {
		if(isEmpty()){
			top = new Node<>(info);
		}else{
		Node<T> temp = new Node<>(info);
		temp.setLink(top);
		top = temp;
		}
	}

	@Override
	public T pop() throws StackException {
		
		if(top == null){
			throw new StackException("The stack is empty!");
		}
		T temp = top.getInfo();
		top = top.getLink();
		return temp;
	}
	@Override
	public T peek() {
		return top.getInfo();
	}

	@Override
	public boolean isEmpty() {
		if(top == null){
			return true;
		}
		return false;
	}

}
