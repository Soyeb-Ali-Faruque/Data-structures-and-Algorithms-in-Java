package Tree;

public class ValidateBinaryTree_Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean currentValidation=(root.left == null || root.val > root.left.val)? true:false;
        currentValidation=(currentValidation && (root.right == null || root.val< root.right.val))? true: false;
        return (currentValidation && isValidBST(root.left) && isValidBST(root.right));
    }
}
