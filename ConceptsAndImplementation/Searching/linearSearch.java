package Searching;

import java.util.Arrays;

public class linearSearch {
    public static void main(String[] args) {
        int[] Test1={1,4,6,7,23,5,6,2};
        int[][] Test2={{4,5,6,2},{8,33,67,23,11}};
//        System.out.println(search1D(Test1,23));
        System.out.println(Arrays.toString(search2D(Test2,24)));



    }
    static int search1D(int[] array,int target){
        for(int i=0;i<array.length;i++){
            if(array[i] == target ) return i;
        }
        return -1;
    }
    static int[] search2D(int[][] array,int target){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(target == array[i][j]) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
