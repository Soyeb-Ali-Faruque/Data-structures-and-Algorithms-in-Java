package bitManipulation_Math;

public class checkPowerOfTwoOrNot {
    public static void main(String[] args) {
        System.out.println(checkPowerOfTwo_optimized(4));
    }

    //Time Complexity --> O(log n)
    //Space Complexity --> O(1)
    static boolean checkPowerOfTwo(int number){
        int count=0;
        while(number>0){
            if((number & 1) == 1){
                count++;
            }
            number>>=1;

        }
        if(count == 1) return true;
        return false;
    }

    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static boolean checkPowerOfTwo_optimized(int number){
        if((number & number-1) == 0 && number > 0) return true;
        return false;
    }
}
