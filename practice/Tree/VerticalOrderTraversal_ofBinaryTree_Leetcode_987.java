package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class VerticalOrderTraversal_ofBinaryTree_Leetcode_987 {
    private static HashMap<Integer,List<Integer>> map=new HashMap<>();
    private static int min=Integer.MAX_VALUE;
    private static int max=Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> ans=new ArrayList<>();
    traverse(root,0);
    for(int i=min;i<=max;i++){
        List<Integer> current=map.get(i);
        Collections.sort(current);
        ans.add(current);
    }

    //reset the workers
    min=Integer.MAX_VALUE;
    max=Integer.MIN_VALUE;
    map=new HashMap<>();

    return ans;

    }
    private static void traverse(TreeNode node,int col){
        if(node == null ) return;
        //calculate min and max
        min=(col < min)?col:min;
        max=(col > max)?col:max;

        //store the value in hash map
        if(map.containsKey(col)){
            map.get(col).add(node.val);
        }
        else{
            List<Integer> current=new ArrayList<>();
            current.add(node.val);
            map.put(col,current);
        }
        //traverse left and right
        traverse(node.left,col-1);
        traverse(node.right,col+1);
    }
}
