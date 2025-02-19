package Array;

import java.util.List;

public class CountItemsMatchingARule_LeetCode_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        int index=-1;
        if(ruleKey.equals("type")) index=0;
        else if(ruleKey.equals("color")) index=1;
        else index=2;
        for(int i=0;i<items.size();i++){
            if(items.get(i).get(index).compareTo(ruleValue) == 0) ans++;
        }
        return ans;
    }
}
