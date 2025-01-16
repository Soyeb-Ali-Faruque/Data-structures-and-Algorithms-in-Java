package Tree;

public class SumRootToLeafNumber_Leetcode_129 {
    int ans=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }















    void helper(TreeNode node,int value){
        int currentCalculatedValue=(value == 0)?node.val : (value*10)+node.val;
        //Leaf node found
        if(node.left == null && node.right == null) ans+=currentCalculatedValue;
        //go to the left if node left is not null
        if(node.left != null ) helper(node.left,currentCalculatedValue);
        //go to the right if node right is not null
        if(node.right != null ) helper(node.right,currentCalculatedValue);
    }

}
