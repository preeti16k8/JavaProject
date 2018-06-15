package binary;

//http://algorithms.tutorialhorizon.com/given-a-binary-tree-find-the-maximum-path-sum-between-any-two-leaves/
public class MaxPathSumBwTwoLeaves {

    public static int maxSoFar =0;
    public int maxPathSum(NodeMP root){
        if(root!=null){
            int leftS = maxPathSum(root.left);
            int rightS = maxPathSum(root.right);
            int sumCurrent;
            if(leftS<0 && rightS<0){
                sumCurrent = root.data;
            }else{
                sumCurrent = Math.max(leftS+rightS+root.data , Math.max(leftS, rightS));
            }
//            sumCurrent = Math.max(leftS+rightS+root.data , Math.max(leftS, rightS));
            if(maxSoFar<sumCurrent){
                maxSoFar = sumCurrent;
            }
            return Math.max(leftS,rightS)+root.data;
        }
        else return 0;
    }
    public void inorder(NodeMP root){
        if(root!=null){
            inorder(root.left);
            System.out.print("  " + root.data);
            inorder(root.right);
        }

    }
    public static void main(String args[]){
    	NodeMP root = new NodeMP(-5);
        root.left = new NodeMP(1);
        root.right = new NodeMP(4);
        root.left.left = new NodeMP(-6);
        root.left.right = new NodeMP(5);
        root.left.right.left = new NodeMP(-2);
        root.left.right.right = new NodeMP(3);
        root.left.left.left = new NodeMP(9);
        root.left.left.right = new NodeMP(10);
        root.right.left = new NodeMP(11);
        root.right.right = new NodeMP(-2);
        root.right.right.right = new NodeMP(-8);
        root.right.right.left = new NodeMP(7);
        root.right.right.right.left = new NodeMP(1);
        root.right.right.right.right = new NodeMP(7);
        root.right.right.right.right.left = new NodeMP(12);

        MaxPathSumBwTwoLeaves m = new MaxPathSumBwTwoLeaves();
        m.maxPathSum(root);
        System.out.println("Max Path Sum Between Two Leaves is " + maxSoFar);
        //m.inorder(root);
    }
}
class NodeMP{
    int data;
    NodeMP left;
    NodeMP right;
    public NodeMP (int data){
        this.data = data;
        left = null;
        right = null;
    }
}