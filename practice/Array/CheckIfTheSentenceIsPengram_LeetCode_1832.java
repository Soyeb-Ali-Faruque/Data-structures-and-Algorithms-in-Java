package Array;

import java.util.HashMap;

public class CheckIfTheSentenceIsPengram_LeetCode_1832 {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        HashMap<Character,Boolean> hold=new HashMap<>();
        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);
            if(hold.containsKey(ch)) continue;
            hold.put(ch,true);
        }
        return (hold.size() ==26);
    }
}
