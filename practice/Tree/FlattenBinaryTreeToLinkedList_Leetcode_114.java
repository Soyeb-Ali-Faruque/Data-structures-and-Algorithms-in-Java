package Tree;

import java.util.ArrayList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList_Leetcode_114 {
    public void flatten(TreeNode root) {
        if(root == null ) return root;
        createLinkedList(root);
        ArrayList<TreeNode> nodes=new ArrayList<>();
        nodes.add(null);
        for(int i=0;i<nodes.size()-1;i++){
            nodes.get(i).left=null;
            nodes.get(i).right=nodes.get(i+1);
        }
        return root;
    }
    void createLinkedList(TreeNode currentNode,ArrayList<TreeNode> nodes){
        if(currentNode == null ) return;
        nodes.add(currentNode);
        createLinkedList(currentNode.left,nodes);
        createLinkedList(currentNode.right,nodes);
    }
}
