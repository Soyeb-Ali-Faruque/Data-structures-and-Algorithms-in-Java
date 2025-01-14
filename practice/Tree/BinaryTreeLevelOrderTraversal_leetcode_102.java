package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_leetcode_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        //queue
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            List<Integer> current=new ArrayList<>();
            for(int i=0;i<level.size();i++){
                TreeNode temp=level.poll();
                if(temp.left!= null) level.add(temp.left);
                if(temp.right!= null) level.add(temp.right);
                current.add(temp.val);
            }
            ans.add(current);
        }
        return ans;
    }
}
