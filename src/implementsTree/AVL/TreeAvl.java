package implementsTree.AVL;

import interfaces.Tree.INode;
import interfaces.Tree.ITreeAvl;

public class TreeAvl<TypeNode extends INode> implements ITreeAvl<TypeNode>{
	
	private TypeNode root;
	
	public TreeAvl() {}

	@Override
	public TypeNode getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(TypeNode root) {
		this.root = root;
	}
	
	@Override
	public String routeInOrder() {
		return this.routeInOrderRecursive(this.getRoot());
	}
	
	private String routeInOrderRecursive(TypeNode p) {
		String res = "";
		
		if (p != null) {
			res = res + this.routeInOrderRecursive((TypeNode) p.getLI());
			res = res + p.getData().toString();
			res = res + this.routeInOrderRecursive((TypeNode) p.getLD());
		}
		
		return res;
	}

	@Override
	public boolean insert(TypeNode node) {
		boolean res = false;
		
		res = insertRecursive(this.getRoot(), null, node);
		
		return res;
	}
	
	public boolean insertRecursive(TypeNode p, TypeNode before, TypeNode node) {
		boolean res = false;
		
		if (p != null) {
			switch (node.getData().compareTo(p.getData())) {
			case -1:
				res = res || this.insertRecursive((TypeNode) p.getLI(), p, node);
				break;
			case 1:
				res = res || this.insertRecursive((TypeNode) p.getLD(), p, node);
				break;
			case 0:
				System.out.println("The node already exists");
				res = false;
				break;
			}
			
		} else if (before != null) {
			switch (node.getData().compareTo(before.getData())) {
			case -1:
				before.setLI(node);
				res = true;
				break;
			case 1:
				before.setLD(node);
				res = true;
				break;
			case 0:
				System.out.println("The node already exists");
				res = false;
				break;
			}
		} else if (this.root == null){
			this.setRoot(node);
			res = true;
		}
		
		return res;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(TypeNode node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void balanceTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeNode simpleRightRotation(TypeNode p, TypeNode q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeNode simpleLeftRotation(TypeNode p, TypeNode q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeNode doubleRightRotation(TypeNode p, TypeNode q, TypeNode r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeNode doubleLeftRotation(TypeNode p, TypeNode q, TypeNode r) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
