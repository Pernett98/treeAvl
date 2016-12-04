package implementsTree.AVL;

import interfaces.Tree.INode;

public class NodeG<Type extends Comparable> implements INode<Type>, Comparable {
	
	private INode<Type> li;
	private INode<Type> ld;
	private Type data;
	private int bf;	
	
	public NodeG(Type data) {
		super();
		this.data = data;
	}

	@Override
	public INode<Type> getLI() {
		return this.li;
	}

	@Override
	public void setLI(INode<Type> li) {
		this.li = li;
	}

	@Override
	public INode<Type> getLD() {
		return this.ld;
	}

	@Override
	public void setLD(INode<Type> ld) {
		this.ld = ld;
	}

	@Override
	public Type getData() {
		return this.data;
	}

	@Override
	public void setData(Type data) {
		this.data = data;
	}

	@Override
	public int getBalanceFactor() {
		return this.bf;
	}

	@Override
	public void setBalanceFactor(int BF) {
		this.bf = BF;
	}
	
	@Override
	public int compareTo(Object o) {
		int res = 0;
		try {
			Type TypeO = (Type) o;
			res = this.getData().compareTo(TypeO);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return res;
	}

}
