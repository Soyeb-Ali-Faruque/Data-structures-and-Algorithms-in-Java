package Tree;

public class PathSum_Leetcode_112 {
    public boolean hasPathSum(TreeNode root,int sum, int targetSum) {
        if(root == null) return false;
        return helper(root,root.val,targetSum);
    }
    boolean helper(TreeNode node,int calculatedSum,int targetSum){
        //current node is leaf node
        if(node.left == null && node.right == null){
            return (calculatedSum == targetSum)?true:false;
        }
        if(node.left != null) {
            if(helper(node.left,calculatedSum+node.left.val,targetSum)) return true;
        }
        return (node.right == null)?false:helper(node.right,calculatedSum+node.right.val,targetSum);
    }
}
