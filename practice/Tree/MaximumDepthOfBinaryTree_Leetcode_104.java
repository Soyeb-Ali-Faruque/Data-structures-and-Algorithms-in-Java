package Tree;

public class MaximumDepthOfBinaryTree_Leetcode_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftSubTreeDepth= maxDepth(root.left);
        int rightSubTreeDepth=maxDepth(root.right);
        return (leftSubTreeDepth > rightSubTreeDepth)?leftSubTreeDepth+1 : rightSubTreeDepth+1;
    }
}
