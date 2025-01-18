package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SymmetricTree_Leetcode_101 {


    public static boolean isSymmetric(TreeNode root) {
        boolean ans=true;
        ArrayList<TreeNode> level=new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size= level.size();
            for(int i=0;i<size;i++){
                TreeNode node=level.remove(0);
                if(node == null) continue;
                level.add(node.left);
                level.add(node.right);
            }
            if(!isSameSide(level)) return false;
        }
        return true;

    }
    static  boolean  isSameSide(ArrayList<TreeNode> level){
        if(level.size() == 1) return true;
        for(int i=0;i<level.size()/2;i++){
            if(level.get(i) != level.get(level.size()-i-1)) return false;
        }
        return true;
    }
}
