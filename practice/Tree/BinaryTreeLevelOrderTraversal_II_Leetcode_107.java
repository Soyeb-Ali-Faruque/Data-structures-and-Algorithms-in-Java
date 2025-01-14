package Tree;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_II_Leetcode_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null) return ans;
        //level queue
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size=level.size();
            List<Integer> current =new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = level.poll();
                //add node's childrens if exist
                if(node.left != null) level.add(node.left);
                if(node.right != null) level.add(node.right);
                current.add(node.val);
            }
            ans.add(0,current);
        }
        return ans;
    }
}
