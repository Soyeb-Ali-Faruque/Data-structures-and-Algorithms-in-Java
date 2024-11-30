package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class recursiveLinearSearch {
    public static void main(String[] args) {

        int[] Test1={1,4,18,9,18,34};
        System.out.println(searchAll(Test1,18,0));

    }
    static int search(int[] array,int target,int index){
        if(index == array.length) return -1;
        if(array[index] == target )  return index;
        else return search(array,target,index+1);
    }
    static ArrayList<Integer> ans =new ArrayList<>();
    static ArrayList<Integer> searchAll(int[] array,int target,int index){
        if(index == array.length) return ans;
        if(array[index] == target ) ans.add(index);
        return searchAll(array,target,index+1);
    }
}
