package interfaces.Tree;

public interface ITree<NodeType extends INode> {

	public NodeType getRoot();
	
	public void setRoot(NodeType root);
	
	public boolean insert(NodeType node);
	
	public int getHeight();
	
	public boolean remove(NodeType node);
	
	public String routeInOrder();
	
	public String routePreOrder();
	
	public String routePosOrder();
	
}
