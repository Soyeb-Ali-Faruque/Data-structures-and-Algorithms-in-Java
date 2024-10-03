package bitManipulation_Math;

public class xorOfNumberFromZeroToNumber {
    public static void main(String[] args) {

        System.out.println(xorSum_optimized(5));

    }

    //Time Complexity --> O(number)
    //Space Complexity --> O(1)
    static int xorSum(int number){
        int ans=0;
        for(int i=1;i<=number;i++){
            ans^=i;
        }
        return ans;
    }


    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int xorSum_optimized(int number){
        if(number % 4 == 0 ) return number;
        if(number % 4 == 1) return 1;
        if(number % 4 == 2) return number+1;
        return 0;// for n54 ==3


    }
}
