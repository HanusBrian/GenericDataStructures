package linkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList("Linked List #1");

		list.add("add 1");
		list.add("add 2");
		list.add("add 3");
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.find("add 2"));
		System.out.println(list.find("add 4"));
		
		list.delete("add 1");
		System.out.println(list.toString());
		
		list.add("add 4");
		System.out.println(list.toString());
		list.delete("add 4");
		System.out.println(list.toString());
		
		list.add("add 5");
		System.out.println(list.toString());
		list.delete("add 3");
		System.out.println(list.toString());
		
		System.out.println(list.find("add 2"));
		System.out.println(list.find("add 45"));
	}

}
