package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
//
//    In summary:
//            - Time complexity: O(n * n!)
//- Space complexity: O(n * n!)
    public static void main(String[] args) {
        int[] array = {1,2,3};

        List<String> list = new ArrayList<>();
        List<List<Integer>> output=new ArrayList<>();
        permutation("",generateString(array),list);
        convert(list,output);
        System.out.println(output);



    }
    private static void convert(List<String> list,List<List<Integer>> output){
        for (int i = 0;i<list.size();i++){
            String str = list.get(i);
            List<Integer> array = new ArrayList<>();
            for(char ch : str.toCharArray()){
                int value = Integer.valueOf(String.valueOf(ch));
                array.add(value);
            }
            output.add(array);
        }

    }
    private static String generateString(int[] array){
        String str = "";
        for(int i=0;i< array.length;i++){
            str += String.valueOf(array[i]);
        }
        return str;
    }

    private static void permutation( String process, String unprocess, List<String> list){
        if(unprocess.length() == 0){
            list.add(process);
            return;
        }
        char ch = unprocess.charAt(0);
        unprocess = unprocess.substring(1,unprocess.length());
        for (int i=0;i<=process.length();i++){
            String str = "";
            str+=process.substring(0,i);
            str+=String.valueOf(ch);

            str+=process.substring(i,process.length());
            permutation(str,unprocess,list);
        }

    }
}
