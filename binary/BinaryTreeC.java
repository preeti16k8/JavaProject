package binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeC {
	private static Node root;
	private int INT_MIN;
	
	
	public void InsertBinaryTree(int i){
		Node newNode=new Node(i);
		if(root==null)root=newNode;
		else{
			Queue<Node> Q=new LinkedList<>();
			Node temp;
			Q.add(root);
			while(!Q.isEmpty()){
				temp=Q.remove();
				if(temp.left!=null)Q.add(temp.left);
				else{
					temp.left=newNode;
					Q.clear();
					return;
				}
				if(temp.right!=null)Q.add(temp.right);
				else{
					temp.right=newNode;
					Q.clear();
					return;
				}
			}
			Q.clear();
				
			}
		}
		
	
	
	public void InsertInBinaryTree(Node root,Node toInsert){
			Queue<Node> Q=new LinkedList<>();
			Node temp;
			Q.add(root);
			while(!Q.isEmpty()){
				temp=Q.remove();
				if(temp.left!=null)Q.add(temp.left);
				else{
					temp.left=toInsert;
					Q.clear();
					return;
				}
				if(temp.right!=null)Q.add(temp.right);
				else{
					temp.right=toInsert;
					Q.clear();
					return;
				}
			}
			Q.clear();	
			}
	
	public void levelOrderTraversalInReverse(Node root){
		Queue<Node> Q=new LinkedList<>();
		Stack<Node> S=new Stack<>();
		Node temp;
		if(root==null)return;
		Q.add(root);
		while(!Q.isEmpty()){
			temp=Q.remove();
			if(temp.right!=null)
				Q.add(temp.right);
			if(temp.left!=null)
				Q.add(temp.left);
			S.push(temp);
		}
		while(!S.isEmpty()){
			System.out.println(S.pop().value);
		}
	} 
	
	
	public void insertR(Node parent,Node toInsert){
		if(toInsert.value<=parent.value){
			if(parent.left==null)parent.left=toInsert;
			else insertR(parent.left,toInsert);
		}
		else
		{
				if(parent.right==null)parent.right=toInsert;
				else insertR(parent.right,toInsert);
			
		}
	}
	public static Node findLCA(Node root,int n1,int n2){
		if(root==null){
			return null;
		}
		int data=root.value;
		if(data>n1 && data>n2){
			return findLCA(root.left,n1,n2);
		}
		if(data<n1 && data<n2){
			return findLCA(root.right,n1,n2);
		}
		return root;
	}
	
	int sizeOfBTusingLevelOrder(BinaryTreeC t){  //without recursion
		Node temp;
		Queue<Node> Q=new LinkedList<>();
		int count=0;
		if(t.root==null)return 0;
		Q.add(t.root);
		while(!Q.isEmpty()){
		temp=Q.remove();
		count++;
		if(temp.left!=null)Q.add(temp.left);
		if(temp.right!=null)Q.add(temp.right);
		}
		Q.clear();
		return count;
	}
	int sizeOfBTusingLevelOrderRoot(Node root){   //without recursion
		Node temp;
		Queue<Node> Q=new LinkedList<>();
		int count=0;
		if(root==null)return 0;
		Q.add(root);
		while(!Q.isEmpty()){
		temp=Q.remove();
		count++;
		if(temp.left!=null)Q.add(temp.left);
		if(temp.right!=null)Q.add(temp.right);
		}
		Q.clear();
		return count;
	}
	
	//recursive approach for finding max in BT
	int findMax(Node root){
		int root_val,left,right,max=INT_MIN;
		if(root!=null){
			root_val=root.value;
			left=findMax(root.left);
			right=findMax(root.right);
			//find largest of three values
			if(left>right)max=left;
			else max=right;
			if(root_val>max)max=root_val;
		}
		return max;
	}
	
	//non recursive(iterative)for finding max element in BT(using level order)
	int findMaxusinglevelOrder(Node root){
		Node temp;
		int max=INT_MIN;
		Queue<Node> Q=new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()){
			temp=Q.remove();
			//largest of three values
			if(max<temp.value)max=temp.value;
			if(temp.left!=null)Q.add(temp.left);
			if(temp.right!=null)Q.add(temp.right);
		}
		Q.clear();
		return max;
	}
	
	public void inOrderSuccessor(Node p){
		if(p.right!=null)
		{
			Node temp=p.right;
			while(temp.left!=null){
				temp=temp.left;
				System.out.println("Inorder Successor"+ temp.value);
			}
		}
	}

	public static void main(String[] args) {
		
		/*BinaryTreeC obj=new BinaryTreeC();
		Node root=new Node(20);
		Node l=new Node(8);
		Node r=new Node(22);
		Node ll=new Node(4);
		Node lr=new Node(12);
		Node lrl=new Node(10);
		Node lrr=new Node(14);
		obj.insertR(root, l);
		obj.insertR(root, r);
		obj.insertR(root, ll);
		obj.insertR(root, lr);
		obj.insertR(root, lrl);
		obj.insertR(root, lrr);
		obj.levelOrderTraversalInReverse(root);
	
		System.out.println(BinaryTreeC.findLCA(root, 8, 4).value);
		System.out.println("LCA:" + BinaryTreeC.findLCA(root, 10, 14).value);
		System.out.println("Max using recursive approach is:"+obj.findMax(root));
		System.out.println("Max using iterative approach is:" +obj.findMaxusinglevelOrder(root));
		//System.out.println(obj.sizeOfBTusingLevelOrder(obj));//obj cant be passed here as root access is inside psvm method
		
		System.out.println(obj.sizeOfBTusingLevelOrderRoot(root));//so pass root here from psvm method

		*/
		
		
		
		/*BinaryTreeC obj=new BinaryTreeC();
		obj.InsertBinaryTree(20);
		obj.InsertBinaryTree(8);
		obj.InsertBinaryTree(22);
		obj.InsertBinaryTree(4);
		obj.InsertBinaryTree(12);
		obj.InsertBinaryTree(10);
		obj.InsertBinaryTree(14);
		obj.levelOrderTraversalInReverse(root);
		System.out.println(obj.sizeOfBTusingLevelOrder(obj));//obj can be passed here as root access is global
		System.out.println(obj.sizeOfBTusingLevelOrderRoot(root));//as root access is global ,root can be passed too
		System.out.println("Max using recursive approach is:"+obj.findMax(root));
		System.out.println("Max using iterative approach is:" +obj.findMaxusinglevelOrder(root));
		obj.inOrderSuccessor(root);*/
		
		
		
		BinaryTreeC obj=new BinaryTreeC();
		Node root=new Node(20);
		Node a=new Node(8);
		Node b=new Node(22);
		Node c=new Node(4);
		Node d=new Node(12);
		Node e=new Node(10);
		Node f=new Node(14);
		obj.InsertInBinaryTree(root, a);
		obj.InsertInBinaryTree(root, b);
		obj.InsertInBinaryTree(root, c);
		obj.InsertInBinaryTree(root, d);
		obj.InsertInBinaryTree(root, e);
		obj.InsertInBinaryTree(root, f);
		obj.levelOrderTraversalInReverse(root);
		System.out.println("Max using recursive approach is:"+obj.findMax(root));
		System.out.println("Max using iterative approach is:" +obj.findMaxusinglevelOrder(root));
		
		
		//System.out.println(obj.sizeOfBTusingLevelOrder(obj));//obj cant be passed here as root access is inside psvm method
		
		System.out.println(obj.sizeOfBTusingLevelOrderRoot(root));//so pass root here from psvm method
		obj.inOrderSuccessor(root);
		obj.inOrderSuccessor(b);
		
		
	}

}

