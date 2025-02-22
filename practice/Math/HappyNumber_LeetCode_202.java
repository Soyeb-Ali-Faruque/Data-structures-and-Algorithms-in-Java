package Math;

public class HappyNumber_LeetCode_202 {
    public boolean isHappy(int n) {
        long a=n;
        long b=n;
        while(b > 1){
            a=sumOfSquare(a);
            b=sumOfSquare(sumOfSquare(b));
            if(a == 1) return true;
            if(a == b) return false;

        }
        return true;
    }
    private long sumOfSquare(long n){
        long sum=0;
        while(n!=0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
