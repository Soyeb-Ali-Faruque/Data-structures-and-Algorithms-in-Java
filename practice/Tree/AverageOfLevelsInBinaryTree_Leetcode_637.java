package Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class AverageOfLevelsInBinaryTree_Leetcode_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size=level.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode temp=level.poll();
                sum+=temp.val;
                if(temp.left != null ) level.add(temp.left);
                if(temp.right != null) level.add(temp.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
