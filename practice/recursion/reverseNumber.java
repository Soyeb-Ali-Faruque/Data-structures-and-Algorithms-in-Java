package recursion;

public class reverseNumber {
    public static void main(String[] args) {
        int n=90;
        int totalDigits=(int) (Math.log(n)/Math.log(10));
        System.out.println(totalDigits);
//        System.out.println(reverse(n,totalDigits));

    }



    //Time complexity --> O(log(n))
    //Space complexity --> O(log(n))
    static int reverse(int n,int digits){
        if( (n/10) == 0 ) return n * (int) Math.pow(10,digits);
        return ((n%10)*(int)(Math.pow(10,digits))) + reverse(n/10,--digits);
    }
}
