package Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] Test1={5,4,1,2,0,6,7,8,9};
        System.out.println(Arrays.toString(array_insertionSort(Test1)));

    }
    static int[] array_insertionSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    //swap
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    continue;
                }
                break;
            }
        }
        return array;
    }
}
