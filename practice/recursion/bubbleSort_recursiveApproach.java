package recursion;

import java.util.Arrays;

public class bubbleSort_recursiveApproach {
    public static void main(String[] args) {
        int[] Test1={4,3,9,5,0,2,1};
        sort(Test1,Test1.length-1,0);
        System.out.println(Arrays.toString(Test1));

    }



    //Time complexity --> O(n^2)
    //Space complexity --> O(n)
    static void sort(int[] array,int r,int c){
        if( r == 0) return;
        if(r == c){
         sort(array,--r,0);
        }else{
            if(array[c] > array[c+1]){
                //swap
                int temp=array[c];
                array[c]=array[c+1];
                array[c+1]=temp;
            }
            sort(array,r,++c);
        }
    }
}
