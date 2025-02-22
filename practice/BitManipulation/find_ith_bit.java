package BitManipulation;

public class find_ith_bit {
    public static void main(String[] args) {
        System.out.println("Number:  "+Integer.toBinaryString(21));
        //Index starts with zero 0 and from left side
        System.out.println(findBitFromRight_optimized(10,4));

    }

    //Time Complexity --> O(log(num))
    //Space Complexity --> O(1)
    static int findBitFromLeft(int number,int index){
        int len=0;
        int num=number;
        while(num>0){
            len++;
            num>>=1;
        }
        if(len<=index) return -1;
        int mask=1;
        int shift=(len-1)-index;
        mask<<=shift;
        int ans= number & mask;
        ans=ans>>shift;
        return ans;
    }


    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int findBitFromRight_optimized(int number,int index){
        number>>=index;
        if((number & 1) ==1){
            return 1;
        }
        return 0;
    }
}
