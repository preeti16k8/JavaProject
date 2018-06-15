package binary;

public class ExistPathSum {
	String path;
	public void hasPath(NodeE root, int sum, String path){
		if(root!=null){
			if(root.data>sum){ // if root is greater than Sum required, return
				return;
			}else{
				path+=" " + root.data; //add root to path
				sum=sum-root.data; // update the required sum
				if(sum==0){ //if sum required =0, means we have found the path
					System.out.println(path);
				}
				hasPath(root.left, sum, path);
				hasPath(root.right, sum, path);
			}			
		}
	}
	public static void main(String[] args) {
		NodeE root = new NodeE(1);
		root.left = new NodeE(2);
		root.right = new NodeE(3);
		root.left.left = new NodeE(7);
		root.left.right = new NodeE(5);
		root.right.left = new NodeE(6);
		root.right.right = new NodeE(7);
		
		ExistPathSum i = new ExistPathSum();
		i.hasPath(root, 10, "");
	}

}

class NodeE {
	int data;
	NodeE left, right;

	public NodeE(int data) {
		this.data = data;
	}
}