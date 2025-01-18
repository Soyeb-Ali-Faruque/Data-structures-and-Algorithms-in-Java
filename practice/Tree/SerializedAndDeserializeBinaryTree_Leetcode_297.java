package Tree;

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

                level.add(null);
                level.add(null);
            }else{
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


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() ==0) return null;

    }
