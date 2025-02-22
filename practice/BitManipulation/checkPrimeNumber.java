package BitManipulation;

public class checkPrimeNumber {

    public static void main(String[] args) {

        System.out.println(isPrime(29));

    }

    //Time Complexity --> O(root(number))
    //Space Complexity --> O(1)
    static boolean isPrime(int number){
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
