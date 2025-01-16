package Tree;

public class LowestCommonAncestorOfABinaryTree_Leetcode_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return root;
        if(root == q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //find lowest ancestor of p and q
        if( left != null && right != null) return root;
        //else
        if(left != null) return left;
        return right;
    }
}
