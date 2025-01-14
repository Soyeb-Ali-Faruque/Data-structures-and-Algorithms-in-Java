package Tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal_leetcode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        //return empty ans if tree is null
        if(root == null) return ans;

        //created double ended queue for storing and managing levels
        Deque<TreeNode> level=new ArrayDeque<>();

        //add root value to the ans list
        ans.add(new ArrayList<>(List.of(root.val)));

        //initial cosideration
        if(root.right != null) level.addLast(root.right);
        if(root.left != null) level.addLast(root.left);

        int checkRev=0;
        while(!level.isEmpty()){
            int size= level.size();
            List<Integer> current=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=(checkRev == 0)?level.pollFirst():level.pollLast();
                if(temp.right != null) {
                    if(checkRev == 0) level.addLast(temp.right);
                    else level.addFirst(temp.right);
                }
                if(temp.left != null) {
                    if(checkRev == 0) level.addLast(temp.left);
                    else level.addFirst(temp.left);
                }
                current.add(temp.val);
            }
            ans.add(current);
            checkRev^=1;
        }
        return ans;

    }
}
