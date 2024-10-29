package recursion;

public class palindromeNumber {
    public static void main(String[] args) {
        System.out.println(check(423321));
    }


    //Time complexity --> O(log(n))
    //Space complexity --> O(log(n))
    static boolean check(int n){
        int digit=(int) (Math.log(n)/Math.log(10)) + 1;
        if(digit == 1) return true;
        if(digit == 2) {
            return ((n/10) == (n % 10));
        }
        int exp=(int) (Math.pow(10,digit-1));
        int s=  (n  / exp );
        n=(n  % exp );
        int e=n % 10;
        n=n/10;
        if(!(s == e)) return false;
        return (s == e) && check(n);
    }
}
