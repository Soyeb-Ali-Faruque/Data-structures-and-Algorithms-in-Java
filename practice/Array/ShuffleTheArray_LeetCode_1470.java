package Array;

public class ShuffleTheArray_LeetCode_1470 {
    public int[] shuffle(int[] nums, int n) {
        int pointer=-1;
        int[] ans=new int[nums.length];
        for(int i=0;i<n;i++){
            ans[++pointer]=nums[i];
            ans[++pointer]=nums[(n+i)];
        }
        return ans;
    }
}
