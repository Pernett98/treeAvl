package implementsTree.AVL;

public class Person implements Comparable{
	
	private Integer id;
	private String name;
	
	public Person () {};
	
	public Person (Integer id, String name) {
		this.setId(id);
		this.setName(name);
	};
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		int res = 0;
		try {
			Person personObject = (Person) o;
				
			if (this.getId() > personObject.getId()) {
				res = 1;
			} else if (this.getId() < personObject.getId()) {
				res = -1;
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "Person: {id: " + this.getId().toString() + ", name: " + this.getName() + "} ";
	} 
	
}
