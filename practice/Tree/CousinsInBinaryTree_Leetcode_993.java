package Tree;

public class CousinsInBinaryTree_Leetcode_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        return (level(root,x,0) == level(root,y,0) && giveParent(root,null,x) != giveParent(root,null,y));
    }
    int level(TreeNode node,int targetNodeValue,int level){
        //no node found in the tree with specified value
        if(node == null) return -1;
        //find the level
        if(node.val == targetNodeValue) return level;
        int levelOfTargetedNode=level(node.left,targetNodeValue,level+1);
        //return the ans if we found the target node level
        if(levelOfTargetedNode != -1) return levelOfTargetedNode;
        return level(node.right,targetNodeValue,level+1);
    }
    TreeNode giveParent(TreeNode node,TreeNode parent,int nodeValue){
        if(node == null ) return node;
        //if we found the child
        if (node.val == nodeValue) return parent;
        TreeNode currentParent=giveParent(node.left,node,nodeValue);
        if(currentParent == null ) currentParent=giveParent(node.right,node,nodeValue);
        return currentParent;
    }
}
