package stackPack;


@SuppressWarnings("serial")
public class StackException extends Exception{
	
	public StackException(){
		super("The stack is empty");
	}
	public StackException(String message){
		 super(message);
	}
}
