package Tree;

public class ConvertSortedArrayToBinarySearchTree_Leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=constructBinarySearchTree(nums,0,nums.length-1);
    }
    TreeNode constructBinarySearchTree(int[] array,int s,int e){
        if(s>e) return null;
        if(s == e) {
            TreeNode node=new TreeNode(array[s]);
            return node;
        }
        int mid=s+(e-s)/2;
        TreeNode current=new TreeNode(array[mid]);
        current.left=constructBinarySearchTree(array,s,mid-1);
        current.right=constructBinarySearchTree(array,mid+1,e);
        return current;
    }
}
