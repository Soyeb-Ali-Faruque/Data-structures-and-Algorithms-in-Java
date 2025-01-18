package Tree;

public class BinaryTreeMaximumPathSum_Leetcode_124 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE > 0);
    }

    int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return max_sum;

    }
    int findMaxPathSum(TreeNode node){
        if(node ==  null ) return 0;
        int left=Math.max(0,findMaxPathSum(node.left));
        int right=Math.max(0,findMaxPathSum(node.right));
        int max=Math.max(Math.max(node.val,node.val+left+right),Math.max(node.val+left,node.val+right));
        if( max > max_sum) max_sum=max;
        return (left > right)?node.val+left : node.val+right;
    }
}
