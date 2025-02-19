package Array;

import java.util.ArrayList;
import java.util.List;

public class Kids_withTheGreatestNumber_ofCandies_LeetCode_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int large=0;
        for(int i=0;i< candies.length;i++){
            if(candies[i]>=large){
                large=candies[i];
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if((candies[i]+extraCandies) >= large){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}
