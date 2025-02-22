package Array;

import java.util.Arrays;

public class CreateTargetArray_intTheGivenOrder_LeetCode_1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans=new int[index.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<index.length;i++){
            if(ans[index[i]] == -1){
                ans[index[i]]=nums[i];

            }else{
                right_shift(ans,index[i]);
                ans[index[i]]=nums[i];
            }
        }
        return ans;
    }

    static void right_shift(int[] array,int index){
        int val=array[index];
        array[index]=-1;
        for(int i=index+1;i<array.length;i++){
            if(array[i] == -1 && val == -1) break;
            int temp=array[i];
            array[i]=val;
            val=temp;
        }


    }
}
