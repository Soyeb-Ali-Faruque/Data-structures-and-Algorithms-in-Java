package Array;

public class BuildArrayFromPermutation_Leetcode_1920 {
    public int[] buildArray(int[] nums) {

        //create an ans array
        int[] ans=new int[nums.length];
        for(int i=0; i<ans.length;i++){
            ans[i]=nums[nums[i]];

        }
        return ans;
    }
}
