package Tree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceK_inBinaryTree_Leetcode_863 {
    static List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root,target,k);
        List<Integer> current_ans=new ArrayList<>();
        current_ans.addAll(ans);
        ans=new ArrayList<>();
        return current_ans;
    }

    private static int find(TreeNode node, TreeNode target, int k) {
        if (node == null) return k;
        if (node == target) {
            if(k == 0){
                ans.add(node.val);

            }else{
                //call to its childs to get kth value
                storeKthValue(node.left, target, k-1);
                storeKthValue(node.right, target, k-1);
            }
            return k - 1;
        } else {
            int val = find(node.left, target, k);
            if (val < k) {
                if (val == 0) {
                    ans.add(node.val);
                    return val - 1;
                }
                storeKthValue(node.right, target, val - 1);
                k=val-1;
            } else {
                val = find(node.right, target, k);
                if (val < k) {
                    if (val == 0) {
                        ans.add(node.val);
                        return val - 1;
                    }
                    storeKthValue(node.left, target, val - 1);
                    k=val-1;
                }
            }
        }


        return k;
    }

    private static void storeKthValue(TreeNode node, TreeNode target, int k) {
        if (k == 0 && node != target && node != null) {
            ans.add(node.val);
        } else if (node == target || node == null || k < 0) return;
        else {
            storeKthValue(node.left, target, k - 1);
            storeKthValue(node.right, target, k - 1);
        }
    }
}
