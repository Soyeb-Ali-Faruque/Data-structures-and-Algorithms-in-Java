package Sorting;

import java.util.Arrays;

public class countSort {
    public static void main(String[] args) {
        int[] Test={4,8,2,1,4,6};
        System.out.println(Arrays.toString(countSort(Test)));

    }


    static int[] countSort(int[] array){
        int max=0;
        //find the largest element
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        int[] index_array =new int[max+1];
        //store the frequescy of that array elements occurrence
        for(int i=0;i<array.length;i++){
            int index=array[i];
            index_array[index]++;

        }

        //sortting the array
        int index=0;
        for(int i=0;i<index_array.length;i++){
            int frequency=index_array[i];
            if(frequency >0){
                while(frequency != 0){
                    array[index]=i;
                    index++;
                    frequency--;
                }
            }
        }

        return array;
    }
}
