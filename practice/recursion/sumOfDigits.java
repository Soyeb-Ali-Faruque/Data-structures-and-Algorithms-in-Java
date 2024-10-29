package recursion;

public class sumOfDigits {
    public static void main(String[] args) {
        System.out.println(digitsSum(0));

    }


    //Time complexity --> O(log(n))
    //Space complexity --> O(log(n))
    static int digitsSum(int number){
        if( ( number / 10) == 0) return number % 10; //last digits or single one digit
        return (number % 10)+digitsSum(number/10);
    }
}
