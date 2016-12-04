package implementsTree.AVL;

import interfaces.Tree.INode;

public class PersonNode implements INode<Person>, Comparable {
	
	private INode<Person> li;
	private INode<Person> ld;
	private Person data;
	
	public PersonNode() {}
	
	public PersonNode(Person data) {
		this.setData(data);
	}
	
	@Override
	public INode<Person> getLI() {
		return this.li;
	}

	@Override
	public void setLI(INode<Person> li) {
		this.li = li;		
	}

	@Override
	public INode<Person> getLD() {
		return this.ld;
	}

	@Override
	public void setLD(INode<Person> ld) {
		this.ld = ld;
	}

	@Override
	public Person getData() {
		return this.data;
	}

	@Override
	public void setData(Person data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(Object o) {
		int res = 0;
		try {
			PersonNode PersonNodeO = (PersonNode) o;
			res = this.getData().compareTo(PersonNodeO);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return res;
	}

}
