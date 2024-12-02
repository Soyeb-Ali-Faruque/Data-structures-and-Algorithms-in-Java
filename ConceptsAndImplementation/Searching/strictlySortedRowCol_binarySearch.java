package Searching;

import java.util.Arrays;

public class strictlySortedRowCol_binarySearch {
    public static void main(String[] args) {
        int[][] Test = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30}
        };
        System.out.println(Arrays.toString(binarySearch(Test,35)));

    }

    //Time Complexity O(log(n))
    //Space Complexity O(1)
    static int[] binarySearch(int[][] array,int target){
        int s=0;
        int e=array.length-1;
        //loop to get atleat 1 or 2 array
        while((e-s)>1) {
            int mid = s + (e - s) / 2;
            if (array[mid][0] == target) return new int[]{mid, 0};
            if (array[mid][0] > target) e = mid - 1;
            else s = mid;
        }// After this we have only 2 options whether i get single 1d array or 2  1d array
        if(s==e) return simpleBinarySearch(array,s,target);
        int[] result=simpleBinarySearch(array,s,target);
        if(result[0]== -1 ) result=simpleBinarySearch(array,e,target);
        return result;
    }

    static int[] simpleBinarySearch(int[][] array,int r,int target){
        int s=0;
        int e=array[0].length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(array[r][mid] == target) return new int[]{r,mid};
            if(array[r][mid] > target) e=mid-1;
            else s=mid+1;
        }
        return new int[]{-1,-1};
    }
}
