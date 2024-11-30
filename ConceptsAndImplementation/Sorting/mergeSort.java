package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] Test={5,6,3,2,1};
        System.out.println(Arrays.toString(merge_sort(Test)));
        System.out.println(Arrays.toString(Test));

    }
//
//    static int[] mergeSort_inPlace(int[] array,int s,int e){}
//    static int[] mergeInPlace(int[] array,int as,int ae,int bs,int be){
//        int i=as;
//        int j=bs;
//        while()
//    }

















    static int[] merge_sort(int[] array) {
        if (array.length == 1) return array;
        int mid = (array.length - 1) / 2;
        int[] arr1=merge_sort(copyRange(array,0,mid));
        int[] arr2=merge_sort(copyRange(array,mid+1, array.length-1));
        return merge(arr1,arr2);
    }
    static int[] merge(int[] a,int[] b){
        int[] ans=new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]>b[j]) ans[k++] = b[j++];
            else ans[k++] = a[i++];
        }
        while(i<a.length){
            ans[k++]=a[i++];
        }
        while(j< b.length){
            ans[k++]=b[j++];
        }
        return ans;
    }

    static int[] copyRange(int[] array,int start,int end){
        int[] arr=new int[(end-start)+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=array[start++];
        }
        return arr;
    }
}
