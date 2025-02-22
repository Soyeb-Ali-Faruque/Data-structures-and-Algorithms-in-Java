package BitManipulation;

public class GCD_OR_HCF {
    public static void main(String[] args) {
        System.out.println(gcd(9,18));
    }



    //Time Complexity --> O(log(min(a,b))
    //Space Complexity --> O(1)
    static int gcd(int a,int b){
        while(a>0){
            int temp=a;
            a=b%a;
            b=temp;
        }
        return b;
    }

    //Time Complexity --> O(log(min(a,b))
    //Space Complexity --> O(log(min(a,b))
    static  int gcd_recursive(int a,int b){
        if(a == 0) {
            return  b;
        }
        return gcd_recursive((b%a),a);
    }
}
