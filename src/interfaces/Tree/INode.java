package interfaces.Tree;

/**
 * @author Sebastian Pernett
 *
 */
public interface INode<Type extends Comparable> {
	
	/**
	 * Returns the left league of the node
	 * @return Node<Type>
	 */
	public INode<Type> getLI();
	
	/**
	 * Sets the left league of the node
	 * @param li Node
	 */
	public void setLI(INode<Type> li);
	
	/**
	 * Returns the right league of the node
	 * @return Node<Type>
	 */
	public INode<Type> getLD();
	
	/**
	 * Sets the right league of the node
	 * @param ld Node
	 */
	public void setLD(INode<Type> ld);
	
	/**
	 * Returns the data of the node
	 * @return data <Type>
	 */
	public Type getData();
	
	/**
	 * Sets the data of the node
	 * @param data Object
	 */
	public void setData(Type data);
	
	
	/**
	 * Returns the balance factor of the node
	 * @return int factor balance
	 */
	public int getBalanceFactor();
	
	/**
	 * Sets the balance factor of the node
	 * @param BF int
	 */
	public void setBalanceFactor(int BF);
		
}
