package Array;

public class FindNumbersWithEvenNumber_ofDigits_LeetCode_1295 {
    public int findNumbers(int[] nums) {
        int ans_count=0;
        for(int i=0;i<nums.length;i++){
            int digit=(int)(Math.log10(nums[i])) + 1;
            if((digit & 1) == 0) ans_count++;
        }
        return ans_count;
    }
}
