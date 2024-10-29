package recursion;

public class powerOfTwo {
    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(16,0));


    }


    //Time complexity --> O(log(n))
    //Space complexity --> O(log(n))
    static boolean isPowerOfTwo(int n,int power) {
        int exp=(int) (Math.pow(2,power++));
        if(exp == n) return true;
        if(exp > n) return false;
        return isPowerOfTwo(n,power);
    }
}
