package implementsTree.AVL;

import interfaces.Tree.ITreeAvl;

public class TreeAvlG<Type extends Comparable> implements ITreeAvl<NodeG<Type>>{
	
	private NodeG<Type> root;	

	public TreeAvlG() {
		super();
	}

	@Override
	public NodeG<Type> getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(NodeG<Type> root) {
		this.root = root;
	}
	
	public boolean insert(Type data) {
		boolean res = this.insert(new NodeG<Type>(data));
		return res;
	}

	@Override
	public boolean insert(NodeG<Type> node) {
		boolean res = this.insertRecursive(this.getRoot(), null, node);
		this.calculateBalanceFactor();
		this.balanceTree();
		return res;
	}
	
	private boolean insertRecursive(NodeG<Type> p, NodeG<Type> before,NodeG<Type> node) {
		boolean res = false;
		
		if (p != null) {
			switch (node.getData().compareTo(p.getData())) {
			case -1:
				res = res || this.insertRecursive((NodeG<Type>) p.getLI(), p, node);
				break;
			case 1:
				res = res || this.insertRecursive((NodeG<Type>) p.getLD(), p, node);
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
		return this.getHeightRecursive(this.getRoot());
	}
	
	
	private int getHeightRecursive(NodeG<Type> p) {
		int res = 0;
		
		if (p != null) {
			res = 1 + Math.max(this.getHeightRecursive((NodeG<Type>) p.getLI()), this.getHeightRecursive((NodeG<Type>) p.getLD()));
		}
		
		return res;
	}

	@Override
	public boolean remove(NodeG<Type> node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String routeInOrder() {
		return this.routeInOrderRecursive(this.getRoot());
	}
	
	private String routeInOrderRecursive(NodeG<Type> p) {
		String res = "";
		
		if (p != null) {
			res = res + this.routeInOrderRecursive((NodeG<Type>) p.getLI());
			res = res + "[fB: " + p.getBalanceFactor() + "] -> " + p.getData().toString();
			res = res + this.routeInOrderRecursive((NodeG<Type>) p.getLD());
		}
		
		return res;
	}

	@Override
	public String routePreOrder() {
		return this.routePreOrderRecursive(this.getRoot());
	}
	
	private String routePreOrderRecursive(NodeG<Type> p) {
		String res = "";
		
		if (p != null) {
			res = res + p.getData().toString();
			res = res + this.routePreOrderRecursive((NodeG<Type>) p.getLI());
			res = res + this.routePreOrderRecursive((NodeG<Type>) p.getLD());
		}
		
		return res;
	}

	@Override
	public String routePosOrder() {
		return this.routePosOrder(this.getRoot());
	}
	
	private String routePosOrder(NodeG<Type> p) {
		String res = "";
		
		if (p != null) {			
			res = res + this.routePreOrderRecursive((NodeG<Type>) p.getLI());
			res = res + this.routePreOrderRecursive((NodeG<Type>) p.getLD());
			res = res + p.getData().toString();
		}
		
		return res;
	} 

	@Override
	public void balanceTree() {
		this.balanceTreeRecursive(this.getRoot(), null);		
	}
	
	private void balanceTreeRecursive(NodeG<Type> p,  NodeG<Type> ant) {
		if (p != null) {
			this.balanceTreeRecursive((NodeG<Type>) p.getLI(), p);
			this.balanceTreeRecursive((NodeG<Type>) p.getLD(), p);
			
			if (p.getBalanceFactor() == 2 && p.getLI() != null && p.getLI().getBalanceFactor() == 1) {
				if (ant == this.getRoot()) {
					this.setRoot(this.simpleRightRotation(p, (NodeG<Type>) p.getLI()));
				} else if (ant.getLI() == p) {
					ant.setLI(this.simpleRightRotation(p, (NodeG<Type>) p.getLI()));					
				} else if (ant.getLD() == p) {
					ant.setLD(this.simpleRightRotation(p, (NodeG<Type>) p.getLI()));
				}
				this.calculateBalanceFactor();
			} else if (p.getBalanceFactor() == -2 && p.getLD() != null && p.getLD().getBalanceFactor() == -1) {
				if (ant == null) {
					this.setRoot(this.simpleLeftRotation(p, (NodeG<Type>) p.getLD()));					
				} else if (ant.getLI() == p) {
					ant.setLI(this.simpleLeftRotation(p, (NodeG<Type>) p.getLD()));					
				} else if (ant.getLD() == p) {
					ant.setLD(this.simpleLeftRotation(p, (NodeG<Type>) p.getLD()));
				}
				this.calculateBalanceFactor();
			} else if (p.getBalanceFactor() == 2 && p.getLI().getBalanceFactor() == -1) {
				if (ant == this.getRoot()) {
					this.setRoot(this.doubleRightRotation(p, (NodeG<Type>) p.getLI()));
				} else if (ant.getLI() == p) {
					ant.setLI(this.doubleRightRotation(p, (NodeG<Type>) p.getLI()));					
				} else if (ant.getLD() == p) {
					ant.setLD(this.doubleRightRotation(p, (NodeG<Type>) p.getLI()));
				}
				this.calculateBalanceFactor();
			} else if (p.getBalanceFactor() == -2 && p.getLD().getBalanceFactor() == 1) {
				if (ant == null) {
					this.setRoot(this.doubleLeftRotation(p, (NodeG<Type>) p.getLD()));					
				} else if (ant.getLI() == p) {
					ant.setLI(this.doubleLeftRotation(p, (NodeG<Type>) p.getLD()));					
				} else if (ant.getLD() == p) {
					ant.setLD(this.doubleLeftRotation(p, (NodeG<Type>) p.getLD()));
				}
				this.calculateBalanceFactor();
			}
			
		}
	}

	@Override
	public NodeG<Type> simpleRightRotation(NodeG<Type> p, NodeG<Type> q) {
		p.setLI(q.getLD());
		q.setLD(p);
		return q;
	}

	@Override
	public NodeG<Type> simpleLeftRotation(NodeG<Type> p, NodeG<Type> q) {
		p.setLD(q.getLI());
		q.setLI(p);
		return q;
	}

	@Override
	public NodeG<Type> doubleRightRotation(NodeG<Type> p, NodeG<Type> q) {
		NodeG<Type> r = (NodeG<Type>) q.getLD();
		q.setLD(r.getLI());
		r.setLI(q);
		p.setLI(r.getLD());
		r.setLD(p);
		return r;
	}

	@Override
	public NodeG<Type> doubleLeftRotation(NodeG<Type> p, NodeG<Type> q) {
		NodeG<Type> r = (NodeG<Type>) q.getLI();
		q.setLI(r.getLD());
		r.setLD(q);
		p.setLD(r.getLI());
		r.setLI(p);		
		return r;
	}

	@Override
	public void calculateBalanceFactor() {
		this.calculateBalanceFactorRecursive(this.getRoot());
	}
	
	private void calculateBalanceFactorRecursive(NodeG<Type> p) {
		if (p != null) {
			this.calculateBalanceFactorRecursive((NodeG<Type>) p.getLI());
			this.calculateBalanceFactorRecursive((NodeG<Type>) p.getLD());
			int balanceFactor = this.getHeightRecursive((NodeG<Type>) p.getLI()) - this.getHeightRecursive((NodeG<Type>) p.getLD()); 
			p.setBalanceFactor(balanceFactor);
		}
	}

}
