package binary;


	// Java program to print right view of Binary
	// Tree    time complexity: O(n)
	import java.util.*;
	 
	public class PrintRightViewUsingQueue 
	{   
	    // Binary tree node
	    private static class NodeRv
	    {
	        int data;
	        NodeRv left, right;
	 
	        public NodeRv(int data) {
	            this.data = data;
	            this.left = null;
	            this.right = null;
	        }
	    }
	     
	    // function to print right view of binary tree
	    private static void printRightView(NodeRv root) 
	    {
	        if (root == null)
	            return;
	             
	        Queue<NodeRv> queue = new LinkedList<>();
	        queue.add(root);
	         
	        while (!queue.isEmpty()) 
	        {   
	            // number of nodes at current level
	            int n = queue.size();
	             
	            // Traverse all nodes of current level 
	            for (int i = 1; i <= n; i++) {
	            	//NodeRv temp = queue.poll();
	            	
	            	NodeRv temp = queue.remove();
	                 
	                // Print the right most element at 
	                // the level
	                if (i == n)
	                    System.out.print(temp.data + " ");
	                 
	                // Add left node to queue
	                if (temp.left != null)
	                    queue.add(temp.left);
	                     
	                // Add right node to queue
	                if (temp.right != null)
	                    queue.add(temp.right);
	            }
	        }
	    }
	 
	    // Driver code
	    public static void main(String[] args) 
	    {
	        // construct binary tree as shown in 
	        // above diagram
	    	NodeRv root = new NodeRv(10);
	        root.left = new NodeRv(2);
	        root.right = new NodeRv(3);
	        root.left.left = new NodeRv(7);
	        root.left.right = new NodeRv(8);
	        root.right.right = new NodeRv(15);
	        root.right.left = new NodeRv(12);
	        root.right.right.left = new NodeRv(14);
	         
	        printRightView(root);
	    }
	}