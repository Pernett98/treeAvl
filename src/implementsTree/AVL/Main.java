package implementsTree.AVL;

public class Main {

	public static void main(String[] args) {
		TreeAvl<PersonNode> tree = new TreeAvl<PersonNode>();
		
		tree.insert(new PersonNode(new Person(1, "Andres")));
		tree.insert(new PersonNode(new Person(5, "Juana")));
		tree.insert(new PersonNode(new Person(5, "Juana")));
		tree.insert(new PersonNode(new Person(7, "Juana")));
		System.out.println(tree.getRoot().getData().toString());
		System.out.println(tree.routeInOrder());
		
		
	}

}
