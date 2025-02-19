package Array;

public class RichestCustomerWealth_LeetCode_1672 {
    public int maximumWealth(int[][] accounts) {
        int highest_amount=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int j=0;j<accounts[i].length;j++){
                sum+=accounts[i][j];
            }
            if(highest_amount<sum){
                highest_amount=sum;
            }
        }
        return highest_amount;
    }
}
