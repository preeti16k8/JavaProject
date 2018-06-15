package binary;
//Java program to print all the node to leaf path

import java.util.*;
class NodeB 
{
	int data;
	NodeB left, right;

	NodeB(int item) 
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree 
{
	NodeB root;
	
	void printPaths(ArrayList<Integer> path) 
	{
	    System.out.println("");
		Iterator it = path.iterator();
		while(it.hasNext())
		{
		    System.out.print(it.next());
		    if(it.hasNext())
		    System.out.print("->");
		}
	}

	void printPathsRecur(NodeB node, ArrayList<Integer> path) 
	{
		if (node == null)
		{
			return;
		}
	    path.add(node.data);
		if (node.left == null && node.right == null)
		{
		    printPaths(path);
		    path.remove(path.size() - 1);
			return;
		}
		
		
     printPathsRecur(node.left, path);
		printPathsRecur(node.right, path); 
		path.remove(path.size() - 1);
		
	}

	// driver program to test above functions
	public static void main(String args[]) 
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new NodeB(10);
		tree.root.left = new NodeB(8);
		tree.root.right = new NodeB(2);
		tree.root.left.left = new NodeB(3);
		tree.root.left.right = new NodeB(5);
		tree.root.right.left = new NodeB(2);
		ArrayList<Integer> path = new ArrayList<Integer>();
		/* Let us test the built tree by printing Insorder traversal */
		tree.printPathsRecur(tree.root, path);
	}
}

