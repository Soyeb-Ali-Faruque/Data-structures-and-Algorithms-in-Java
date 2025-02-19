package Array;

public class RunningSum_of1dArray_LeetCode_1480 {
    public int[] runningSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            nums[i]+=sum;
            sum+=val;
        }return nums;
    }
}
