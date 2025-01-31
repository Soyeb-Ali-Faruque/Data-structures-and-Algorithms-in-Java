package Tree;

import com.sun.source.tree.Tree;

public class SumOfLeftLeaf_Leetcode_404 {

    private static int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        calculateSum(root);
        int ans=sum;
        sum=0;
        return ans;
    }
    static void calculateSum(TreeNode node){
        if(node == null) return;
        if(node.left != null) {
            //make sum if current node's left is a leaf node
            if (isLeafNode(node.left)) sum += node.left.val;
            calculateSum(node.left);
        }if(node.right != null){
            calculateSum(node.right);
        }
    }
    private static boolean isLeafNode(TreeNode node){
        if(node == null) return false;
        if(node.left == null && node.right == null) return true;
        return false;
    }
}
