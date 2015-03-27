package stackPack;

public class TestStack {

	public static void main(String[] args) throws StackException {
		try{
			Stack<String> stack = new Stack<>();
			//System.out.println(stack.pop());
			stack.push("12");
			stack.push("236");
			System.out.println(stack.peek());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			stack.push("234");
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}catch(StackException e){
			System.out.println(e);
		}
	}
}
