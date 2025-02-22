package BitManipulation;

public class findNumberOfDigitsInBaseB {
    public static void main(String[] args) {
        System.out.println(countDigits_optimized(20,2));
    }

    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int countDigits_optimized(int number,int base){
        int ans=(int)(Math.log(number)/Math.log(base))+1;
        return ans;
    }
}
