package binary;

/*Naive Approach:
http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
Find the height of left subtree.
Find the height of right subtree.
Find the left diameter.
Find the right diameter.
Return the Maximum(Diameter of left sub­tree,
		Diam­e­ter of right sub­tree,
		Longest path between two nodes which passes through the root.)
Time Com­plex­ity: Since when cal­cu­lat­ing the diam­e­ter, 
every iter­a­tion for every node, is cal­cu­lat­ing height of tree 
sep­a­rately in which we iter­ate the
tree from top to bot­tom and when we cal­cu­late diam­e­ter recur­sively so its O(N2)*/

public class DiameterOfTree {

	public int getHeight(NodeDT root) {
		if (root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public int Diameter(NodeDT root) {
		if (root != null) {
			// get the left and right subtree height
			int leftH = getHeight(root.left);
			int rightH = getHeight(root.right);

			// get the left diameter and right diameter recursively.
			int leftDiameter = Diameter(root.left);
			int rightDiameter = Diameter(root.right);

			// get the max leftsubtree, rightsubtree, longest path goes through
			// root.
			return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
		}
		return 0;
	}

	public int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	public static void main(String[] args) {
		NodeDT root = new NodeDT(1);
		root.left = new NodeDT(2);
		root.right = new NodeDT(3);
		root.left.left = new NodeDT(4);
		root.left.right = new NodeDT(5);
		root.left.right.left = new NodeDT(6);
		root.left.right.left.right = new NodeDT(7);
		root.left.left.left = new NodeDT(8);

		DiameterOfTree d = new DiameterOfTree();
		System.out.println("Diameter of Tree:" + d.Diameter(root));

	}
}

class NodeDT {
	int data;
	NodeDT left;
	NodeDT right;

	public NodeDT(int data) {
		this.data = data;
	}
}