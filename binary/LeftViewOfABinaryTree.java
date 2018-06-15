package binary;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfABinaryTree {
	NodeLv root;
	static int max_level=0;
	class NodeLv{
		int key;
		NodeLv left;
		NodeLv right;
		NodeLv(int data){
			key=data;
			left=right=null;
		}
	}
	void makeTree(){
		 this.root = new NodeLv(12);
		 this.root.left = new NodeLv(10);
		 this.root.right = new NodeLv(30);
		 this.root.right.left = new NodeLv(25);
		 this.root.right.right = new NodeLv(40);
	}
	void getLeftView(NodeLv node, int level) {
		if(node==null)
			return;
		if(max_level<level){
			System.out.print(node.key+" ");
			max_level=level;
		}
		getLeftView(node.left,level+1);
		getLeftView(node.right,level+1);
	}
	void leftView2(NodeLv node){
		if(node==null)
			return;
		Queue<NodeLv> q=new LinkedList<NodeLv>();
		q.add(node);
		q.add(null);
		boolean isFirst=true;
		while(!q.isEmpty()){
			//NodeLv temp=q.peek();
			//q.poll();
			NodeLv temp=q.remove();
			
			if(isFirst&&temp!=null){
				System.out.print(temp.key+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				isFirst=false;
			}
			else if(temp==null && q.size()>1){
				isFirst=true;
				q.add(null);
			}
			else if(temp!=null){
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
		
	
	public static void main(String[] args) {
		LeftViewOfABinaryTree tree=new LeftViewOfABinaryTree();
		tree.makeTree();
		System.out.println("Left View using recursion is: ");
		tree.getLeftView(tree.root, 1);
		System.out.println("\nLeft View without using recursion is: ");
		tree.leftView2(tree.root);
	}
	

}
