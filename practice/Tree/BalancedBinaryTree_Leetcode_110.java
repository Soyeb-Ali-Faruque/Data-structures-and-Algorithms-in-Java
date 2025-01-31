package Tree;

public class BalancedBinaryTree_Leetcode_110 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(10);
        System.out.println(isBalanced(node));
    }
    private static  boolean ans=true;
    public static boolean isBalanced(TreeNode root) {
       checkBalanced(null);
        return ans;
    }
    static int  checkBalanced(TreeNode node) {
        if(node == null) return -1;
        int left=checkBalanced(node.left);
        int right=checkBalanced(node.right);
        if(ans) ans=balanceFactor(left,right);
        return Math.max(left,right)+1;
    }
    static boolean balanceFactor(int a,int b){
        int diff=a-b;
        return (diff >= -1 && diff <=1)? true:false;
    }
}
