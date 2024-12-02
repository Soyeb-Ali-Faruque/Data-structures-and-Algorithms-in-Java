package Searching;

import java.util.Arrays;

public class sortedRowCol_binarySearch {
    public static void main(String[] args) {
        int[][] Test = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        System.out.println(Arrays.toString(binarySearch(Test,32)));

    }

    //Time Complexuty O(n)
    //Space Complexity O(1)
    static int[] binarySearch(int[][] array,int target){
        int s=0;
        int e=array[0].length-1;
        while(s<array.length && e >=0){
            if(target == array[s][e]) return new int[]{s,e};
            if( target > array[s][e]) s++;
            else e--;
        }

        return new int[]{-1,-1};
    }


}
