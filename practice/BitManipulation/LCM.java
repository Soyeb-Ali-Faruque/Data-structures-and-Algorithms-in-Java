package BitManipulation;

public class LCM {
    public static void main(String[] args) {

    }


    //Time Complexity --> O(log(min(a,b))
    //Space Complexity --> O(1)
    static int lcm(int a,int b){
        return a*b/GCD_OR_HCF.gcd(a,b);
    }
}
