package binaryTreePack;

public class TestBinaryTree {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		
		System.out.println(tree.root);
		System.out.println(tree.root.getRight());
		System.out.println(tree.root.getRight().getRight());
		
		System.out.println("size is " + tree.size());
		System.out.println("height is " + tree.height());
		
		BinaryTree<Integer> tree2 = new BinaryTree<>();
		tree2.add(20);
		tree2.add(10);
		tree2.add(30);
		tree2.add(5);
		tree2.add(15);
		tree2.add(25);
		tree2.add(35);
		tree2.add(20);
		
		System.out.println(tree2.root);
		System.out.println(tree2.root.getRight());
		System.out.println(tree2.root.getRight().getRight());
		System.out.println(tree2.root.getRight().getLeft());
		
		System.out.println(tree2.root.getLeft());
		System.out.println(tree2.root.getLeft().getLeft());
		System.out.println(tree2.root.getLeft().getRight());
		System.out.println(tree2.root.getLeft().getRight().getRight());
		
		System.out.println("size is " + tree2.size());
		System.out.println("height is " + tree2.height());
		
		System.out.println(tree2.find(10));
		System.out.println(tree2.find(2));

		System.out.println("In order sort\n----------------");
		tree2.displayInOrder();
		System.out.println("Preorder sort\n----------------");
		tree2.displayPreOrder();
		System.out.println("Post order sort\n----------------");
		tree2.displayPostOrder();
	}

}
