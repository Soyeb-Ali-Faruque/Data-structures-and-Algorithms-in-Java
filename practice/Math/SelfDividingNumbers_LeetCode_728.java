package Math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_LeetCode_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            boolean self_dividing=true;//initial state
            int number=i;
            while(number>0){
                //get digits;
                int digit=number%10;
                number/=10;
                if(digit ==0 || ((i % digit) != 0)) {
                    self_dividing = false;
                    break;
                }
            }
            if(self_dividing ) {
                ans.add(i);

            }
        }
        return ans;
    }
}
