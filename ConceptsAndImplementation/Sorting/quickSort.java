package Sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,0};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //swapts the value of indexes a and b
    private static void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    //array, starting index ending index of array or sub array
    private static void sort(int array[],int a,int b){
        if(a >= b) return;
        int m=(a+b)/2;
        int pivot = array[m];
        int i=a;
        int j=b;
        while(i<=j){
            if(array[i] < pivot) i++;
            if(array[j] > pivot) j--;
            if(array[i] > pivot && array[j] < pivot){
                swap(array,i,j);
                i++;
                j--;
            }
        }
        if(j >= 0) swap(array,m,j);

        //call left
        sort(array,a,j-1);
        //call right
        sort(array,j+1,b);
    }


}
