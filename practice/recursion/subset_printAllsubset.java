package recursion;

import java.util.ArrayList;
import java.util.List;

public class subset_printAllsubset {
    public static void main(String[] args) {
        List<String> ans=subset("","abc");
        System.out.println(ans);

    }
    static void subsetPrint(String subset,String input){
        if(input.length() == 0) {
            System.out.println(subset);
            return;
        }
        subsetPrint(subset+input.charAt(0),input.substring(1));
        subsetPrint(subset,input.substring(1));
    }

    static void subset(String subset,String input,List<String> str){
        if(input.length() == 0) {
            str.add(subset);
            return;
        }
        subset(subset+input.charAt(0),input.substring(1),str);
        subset(subset,input.substring(1),str);
    }

    static List<String> subset(String subset,String input) {
        List<String> subAns=new ArrayList<>();
        if(input.length() == 0) {
            subAns.add(subset);
            return subAns;
        }
        subAns.addAll(subset(subset+input.charAt(0),input.substring(1)));
        subAns.addAll(subset(subset,input.substring(1)));

        return subAns;
    }

}
