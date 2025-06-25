package Searching;

public class Search_inRotatedArray_LeetCode_33 {
    public int search(int[] nums, int target) {
        int pivot=getPivot(nums);
        int targetIndex=getIndex(nums,target,pivot,nums.length-1);
        if(targetIndex > 0) return targetIndex;
        return getIndex(nums,target,0,pivot-1);

    }
    private static int getPivot(int[] array){
        int s=0;
        int e= array.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(array[mid]>array[e]) s=mid+1;
            else e=mid;
        }
        return s;
    }
    private static int getIndex(int[] array,int target,int s,int e){
        if(e == -1) return -1;
        //binary search
        while(s<=e){
            int mid=s+(e-s)/2;
            if(array[mid] == target) return mid;
            else if(array[mid] > target) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }

}
