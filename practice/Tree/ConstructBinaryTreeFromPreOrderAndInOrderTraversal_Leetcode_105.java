package Tree;

public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal_Leetcode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len=preorder.length-1;
        TreeNode root=constructTree(preorder,inorder,0,len,0,len);
        return root;
    }

    /** here parameters include a node and PS PS IS IE
     *
     * @param PS is Preorder start pointer
     * @param PE is preorder end pointer
     * @param IS is inorder start pointer
     * @param IE is inorder end pointer
     * @return node
     */
    TreeNode constructTree(int[] preoder,int[] inorder,int PS,int PE,int IS,int IE){
        if(PS == PE){
            TreeNode leafNode=new TreeNode(preoder[PS]);
            return leafNode;
        }
        //create treenode
        TreeNode internalNode=new TreeNode(preoder[PS]);
        int index=findNodeIndex(inorder,preoder[PS],IS,IE);
        PS++;
        internalNode.left=constructTree(preoder,inorder,PS,PS+((index-1)-IS),IS,index-1);
        internalNode.right=constructTree(preoder,inorder,(PS+((index-1)-IS))+1,PE,index+1,IE);
        return internalNode;
    }
    int findNodeIndex(int[] array,int target,int s,int e){
        int index=-1;
        for(int i=s;i<=e;i++){
            if(array[i] == target) {
                index=i;
                break;
            }
        }
        return index;
    }
}
