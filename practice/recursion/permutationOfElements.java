package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationOfElements {
    public static void main(String[] args) {
        List<String> ans=new ArrayList<>();

        printArrangement("","abc",ans);
        System.out.println(ans);

    }
    static void printArrangement(String permutation,String input){
        if(input.length() == 0){
            System.out.println(permutation);
            return;
        }

        for(int i=0;i<=permutation.length();i++){
            String curr=permutation.substring(0,i);
            curr+=input.charAt(0);
            curr+=permutation.substring(i,permutation.length());
            printArrangement(curr,input.substring(1));
        }

    }

    static void printArrangement(String permutation,String input,List<String> str){
        if(input.length() == 0){
            str.add(permutation);
            return;
        }

        for(int i=0;i<=permutation.length();i++){
            String curr=permutation.substring(0,i);
            curr+=input.charAt(0);
            curr+=permutation.substring(i,permutation.length());
            printArrangement(curr,input.substring(1));
        }

    }


}
