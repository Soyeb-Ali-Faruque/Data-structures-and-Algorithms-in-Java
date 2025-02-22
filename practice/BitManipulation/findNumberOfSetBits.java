package BitManipulation;

public class findNumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(58));
        System.out.println(findSetBits_optimized(2));
    }

    //Time Complexity --> O(log(number))
    //Space Complexity --> O(1)
    static int findSetBits(int number){
        int ans=0;
        while(number > 0){
            if((number & 1) == 1){
                ans++;
            }
            number>>=1;
        }
        return ans;
    }


    //Perform better in average case as loop run == the number of set bits in the number

    //avg case Time complexity O(k) //k represents the number of set bits
    //Time Complexity --> O(log(number)) in worst case
    //Space Complexity --> O(1)
    static int findSetBits_optimized(int number){
        int ans=0;
        while(number>0){
            ans++;
            number=number - (number & -number);
        }return ans;
    }
}
