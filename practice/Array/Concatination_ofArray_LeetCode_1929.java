package Array;

public class Concatination_ofArray_LeetCode_1929 {
    public int[] getConcatenation(int[] nums) {
        int[] ans=new int[nums.length*2];
        for(int i=0; i< nums.length;i++){
            int val=nums[i];
            ans[i]=val;
            ans[i+nums.length]=val;
        }
        return ans;
    }
}
