package binary;


	public class DiameterOfTreeOptimised {
		int diameter = 0;

		// here in improved solution, we calculate the height and diameter for every
		// node in same iteration
		// every Node will return 2 values, diameter and height wrt to the
		// particular node
		//http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
		public int[] Diameter(NodeDT root) {
			int DandH[] = { 0, 0 }; // initialize the height (DandH[0]) and diameter
									// as 0 (DandH[1])
			if (root != null) {

				int[] leftResult = Diameter(root.left);
				int[] rightResult = Diameter(root.right);

				int height = Math.max(leftResult[0], rightResult[0]) + 1;
				int leftDiameter = leftResult[1];
				int rightDiameter = rightResult[1];
				int rootDiameter = leftResult[0] + rightResult[0] + 1;
				int finalDiameter = getMax(leftDiameter, rightDiameter,
						rootDiameter);
				// prepare the DandH[]
				DandH[0] = height; // update the height
				DandH[1] = finalDiameter;
				return DandH;
			}
			return DandH;
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

			DiameterOfTreeOptimised d = new DiameterOfTreeOptimised();
			System.out.println("Diameter of Tree   " + d.Diameter(root)[1]);
		}
	}

	/*class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}*/