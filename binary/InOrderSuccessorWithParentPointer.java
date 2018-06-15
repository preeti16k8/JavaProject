package binary;
public class InOrderSuccessorWithParentPointer {
	public NodeP findInOrderSuccessor(NodeP root, NodeP x){
		//if the right child of x is not null then in-Order successor will the left most node in
		//the right sub tree of x.
		if(x.right!=null){
			return leftMostNode(x.right);
		}
		NodeP parent = x.parent;
		while(parent!=null && x==parent.right){
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}
	public NodeP leftMostNode(NodeP x){
		while(x.left!=null){
			x = x.left;
		}
		return x;
	}
	public void display(NodeP root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String args[]){
		NodeP root = new NodeP(10);
		root.left = new NodeP(5);
		root.left.parent = root;
		root.right = new NodeP(15);
		root.right.parent = root;
		root.left.left = new NodeP(3);
		root.left.left.parent = root.left;
		root.right.left = new NodeP(17);
		root.right.left.parent = root.right;
		NodeP a = new NodeP(7);
		root.left.right = a;
		root.left.right.parent = root.left;
		InOrderSuccessorWithParentPointer b = new InOrderSuccessorWithParentPointer();
		System.out.print(" Tree : ");
		b.display(root);
		System.out.println();
		NodeP x = b.findInOrderSuccessor(root, a);
		if(x!=null){
			System.out.println("InOrder Successor of " + a.data + " is " + x.data);
		}else{
			System.out.println("InOrder Successor of " + a.data + " is NULL");
		}
		x = b.findInOrderSuccessor(root, root);
		if(x!=null){
			System.out.println("InOrder Successor of " + root.data + " is " + x.data);
		}else{
			System.out.println("InOrder Successor of " + root.data + " is NULL");
		}
	}
}
class NodeP{
	int data;
	NodeP left;
	NodeP right;
	NodeP parent;
	public NodeP(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}