package Tree;

public class KthSmallestElementInABinarySearchTree_Leetcode_230 {

 int count=0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return findKthSmallestValue(root);
    }
    int findKthSmallestValue(TreeNode node){
        if(node == null) return -1;
        int ans=findKthSmallestValue(node.left);
        if(count == 1) return node.val;
        count--;
        if(ans == -1) ans=findKthSmallestValue(node.right);
        return ans;
    }
}
