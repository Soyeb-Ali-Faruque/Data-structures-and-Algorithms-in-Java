package Tree;

public class DiameterOfBinaryTree_Leetcode_543 {

    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    int helper(TreeNode node){
        if(node == null ) return 0;
        int left=helper(node.left);
        int right=helper(node.right);
        if(left+right > diameter) diameter=left+right;
        return (left > right )?left+1;right+1;
    }
}
