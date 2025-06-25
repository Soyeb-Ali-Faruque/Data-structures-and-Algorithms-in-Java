package Searching;

public class FindFirst_andLastPosition_ofElement_inSortedArray_LeetCode_34 {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,5,5,6,7};
        System.out.println(rightEnd(arr,4));
    }
    public int[] searchRange(int[] nums, int target) {
        int index=getIndex(nums,target);
        if(index == -1) return new int[]{-1,-1};
        int left=leftEnd(nums,index);
        int right=rightEnd(nums,index);
        return new int[]{left,right};
    }
    private static int leftEnd(int[] array,int index){
        if(index == 0) return index;
        int s=0;
        int e=index;
        while(s<e){
            int mid=s+(e-s)/2;
            if(array[mid] == array[index]) e=mid;
            else s=mid+1;
        }
        return s;
    }
    private static int rightEnd(int[] array,int index){
        if(index == array.length-1) return index;
        int s=index;
        int e= array.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(array[mid+1] == array[index]) s=mid+1;
            else e=mid;
        }
        return s;
    }
    private static int getIndex(int[] array,int target){
        //binary search
        int s=0;
        int e= array.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(array[mid] == target) return mid;
            else if(array[mid] > target) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}
