package Tree;

public class MinimumDepthOfBinaryTree_Leetcode_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left=minDepth(root.left);
        if(left == 0) left=Integer.MAX_VALUE;
        int right=minDepth(root.right);
        if(right == 0) right=Integer.MAX_VALUE;
        return Math.min(left,right)+1;
    }


}
