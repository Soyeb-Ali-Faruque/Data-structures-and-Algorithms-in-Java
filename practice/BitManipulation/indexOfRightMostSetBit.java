package BitManipulation;

public class indexOfRightMostSetBit {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(96));
        System.out.println(indexOfSetBitFromRight_optimized(96));
    }

    //Time Complexity --> O(log(number))
    //Space Complexity --> O(1)
    static int indexOfSetBitFromRight(int number){
        int index=0;
        while(number>0){
            if((number &1)  == 1){
                break;
            }index++;
            number>>=1;
        }return index;
    }


    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int indexOfSetBitFromRight_optimized(int number){
        number= number & (-number);
        int ans = (int) (Math.log(number)/Math.log(2));
        return ans;
    }




}
