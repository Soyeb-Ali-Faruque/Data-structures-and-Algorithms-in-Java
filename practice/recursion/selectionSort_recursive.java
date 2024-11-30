package recursion;

import java.util.Arrays;

public class selectionSort_recursive {
    public static void main(String[] args) {
        int[] Test1={4,3,9,5,2,1};
        sort(Test1,Test1.length-1,0,0);
        System.out.println(Arrays.toString(Test1));

    }



    //Time complexity --> O(n^2)
    //Space complexity --> O(n)
    static void sort(int[] array,int row,int col,int largestElementIndex){
        if(row == 0) return;
        if(row>=col){
            if(array[largestElementIndex] < array[col]) largestElementIndex=col;
            sort(array,row,++col,largestElementIndex);
        }
        else{
            //swap
            int temp=array[largestElementIndex];
            array[largestElementIndex] = array[row];
            array[row]=temp;
            sort(array,--row,0,0);
        }
    }
}
