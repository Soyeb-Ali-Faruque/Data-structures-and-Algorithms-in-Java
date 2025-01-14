package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_Leetcode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root == null ) return ans;
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size=level.size();
            for(int i=0;i<size;i++) {
                TreeNode temp = level.poll();
                if (i == size - 1) ans.add(temp.val);
                if (temp.left != null) level.add(temp.left);
                if (temp.right != null) level.add(temp.right);
            }
        }
        return ans;
    }

    }

