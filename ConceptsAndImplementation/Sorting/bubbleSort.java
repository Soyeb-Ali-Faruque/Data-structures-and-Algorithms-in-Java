package Sorting;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] Test1={5,4,1,2,3,6};
        System.out.println(Arrays.toString(array_bubbleSort(Test1)));
    }
    static int[] array_bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    //swap
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        return array;
    }
}
