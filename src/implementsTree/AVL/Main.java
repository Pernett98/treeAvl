package implementsTree.AVL;

public class Main {

	public static void main(String[] args) {
		TreeAvlG<Person> tree = new TreeAvlG<Person>();
		
		tree.insert(new Person(1, "Andres"));
		tree.insert(new Person(2, "Juana"));		
		tree.insert(new Person(3, "Juana"));
		tree.insert(new Person(4, "Juana"));		
		tree.insert(new Person(5, "Juana"));
		
		System.out.println(tree.getRoot().getData().toString());
		System.out.println(tree.routeInOrder());
		System.out.println(tree.getHeight());
		
		System.out.println('\n');
		
		TreeAvlG<Integer> treeI = new TreeAvlG<Integer>();
		
		treeI.insert(1);
		treeI.insert(2);
		treeI.insert(3);
		treeI.insert(4);
		treeI.insert(5);
		
		System.out.println(treeI.getRoot().getData().toString());
		System.out.println(treeI.routeInOrder());
		System.out.println(treeI.getHeight());
		
		
	}

}
