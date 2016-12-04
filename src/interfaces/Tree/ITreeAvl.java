package interfaces.Tree;

public interface ITreeAvl <NodeType extends INode> extends ITree<NodeType> {
	
	public void balanceTree();

	public NodeType simpleRightRotation(NodeType p ,NodeType q);
	
	public NodeType simpleLeftRotation(NodeType p ,NodeType q);
	
	public NodeType doubleRightRotation(NodeType p, NodeType q, NodeType r);
	
	public NodeType doubleLeftRotation(NodeType p, NodeType q, NodeType r);
	
}
