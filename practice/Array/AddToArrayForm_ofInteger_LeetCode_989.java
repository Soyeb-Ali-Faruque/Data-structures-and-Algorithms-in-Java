package Array;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm_ofInteger_LeetCode_989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        int carry=0;
        int i=num.length-1;
        while(i >=0 && k !=0){
            int a=num[i--];
            int b=k%10;
            k/=10;
            int sum=a+b+carry;
            carry=sum/10;
            ans.add(0,sum%10);
        }
        while(k !=0){
            int sum=carry+(k%10);
            ans.add(0,sum%10);
            k/=10;
            carry=sum/10;
        }
        while(i >=0){
            int sum=carry+num[i--];
            ans.add(0,sum%10);
            carry=sum/10;
        }
        if(carry != 0) ans.add(0,carry);
        return ans;

    }
}
