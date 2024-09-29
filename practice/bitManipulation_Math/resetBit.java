package bitManipulation_Math;

public class resetBit {
    public static void main(String[] args) {
        System.out.println("Reset means turn the bit to 0 if it is 1 or remain 0 if it is already 0");
        System.out.println("Index here starts from left side");
        int number=10;
        System.out.println("Number:  "+number);
        System.out.println("Binary representation:  "+Integer.toBinaryString(number));
        System.out.println("Answer:  "+reset(number,3));
    }
    static String reset(int number,int index){
        int len=Integer.toBinaryString(number).length();
        if(len <= index) return "Index out of bound";
        int mask=1;
        mask<<=index;
        number&=~(mask);
        return Integer.toBinaryString(number);
    }
}
