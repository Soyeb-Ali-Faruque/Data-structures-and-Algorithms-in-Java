package BitManipulation;

public class xorOfNumbersInRange {
    public static void main(String[] args) {
        System.out.println(xorSumRangeOf(0,10));
        System.out.println(optimized_xorSumRangeOf(0,10));

    }


    //Time Complexity --> O(1) here  n= b-a+1
    //Space Complexity --> O(1)
    static int xorSumRangeOf(int a,int b){
        int ans=0;
        for(int i=a;i<=b;i++){
            ans^=i;
        }
        return ans;
    }


    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int optimized_xorSumRangeOf(int a,int b){
        int ans=xorOfNumberFromZeroToNumber.xorSum_optimized(b) ^ xorOfNumberFromZeroToNumber.xorSum_optimized(a-1);

        return ans;
    }
}
