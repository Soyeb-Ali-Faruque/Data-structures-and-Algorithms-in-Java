package bitManipulation_Math;

public class find_ith_bit {
    public static void main(String[] args) {
        System.out.println("Number:  "+Integer.toBinaryString(21));
        //Index starts with zero 0 and from right side
        System.out.println(findBit(21,3));

    }
    static int findBit(int number,int index){
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
        System.out.println("mask: "+ Integer.toBinaryString(mask));
        int ans= number & mask;
        ans=ans>>shift;
        return ans;
    }
}
