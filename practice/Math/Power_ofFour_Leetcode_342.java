package Math;

public class Power_ofFour_Leetcode_342 {
    public boolean isPowerOfFour(int n) {
        if((n > 0) && ((n & (n-1)) == 0) && ((digitOf(n) & 1) == 1)){
            return true;
        }
        return false;
    }

    //calculate the digits for binary representation
    static int digitOf(int number){
        return (int) (Math.log(number)/Math.log(2)) + 1;
    }
}
