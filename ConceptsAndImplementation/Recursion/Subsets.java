package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        List<String> subsets = new ArrayList<>();
        generateSubsets("","abc",subsets);
        System.out.println(subsets);

    }
    private static void generateSubsets(String proceed, String unProcessed, List<String> subsets){
        if(unProcessed.length() == 0){
            subsets.add(proceed);
            return;
        }
        char ch = unProcessed.charAt(0);
        unProcessed = unProcessed.substring(1);
        generateSubsets(proceed+ch,unProcessed,subsets);
        generateSubsets(proceed,unProcessed,subsets);
    }
}
