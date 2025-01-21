package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializedAndDeserializeBinaryTree_Leetcode_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ) return "";
        String serialisedTree="";
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        int levelWindow=2;
        int iterator=0;
        int lock=0;
        boolean breakpoint=true;
        while(true){
            TreeNode node=level.poll();

            //set lock if we found first node in a level
            if(node != null && lock == 0){
                breakpoint=false;
                lock=1;
            }

            //add to the queue
            if(node == null){

                //break conditions for loop
                if(iterator == levelWindow && breakpoint) break;
                serialisedTree+="n";
                level.add(null);
                level.add(null);
            }else{
                serialisedTree+=node.val;
                level.add(node.left);
                level.add(node.right);
            }


            if(iterator == levelWindow){
                iterator=1;
                levelWindow=levelWindow*2;
                breakpoint=true;
                lock=0;
            }else iterator++;

        }


        return serialisedTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() ==0) return null;
        ArrayList<TreeNode> pool=new ArrayList<>();
        for(int i=0;i<data.length();i++) {
            if (data.charAt(i) == 'n') pool.add(null);
            else {
                TreeNode next = new TreeNode(data.charAt(i) - '0');
                pool.add(next);
            }
        }
        //develop tree
        int connectionPointer=1;
        int nodePointer=0;
        while(connectionPointer< pool.size()){
            if(pool.get(nodePointer) == null){
                nodePointer++;
                connectionPointer+=2;
            }
            TreeNode node=pool.get(nodePointer++);
            node.left=pool.get(connectionPointer++);
            node.right=pool.get(connectionPointer++);
        }

        return pool.get(0);
    }


}
