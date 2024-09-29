package bitManipulation_Math;

public class setBit {
    public static void main(String[] args) {
        System.out.println("Set means turn the bit to 1 if it is 0 or remain 1 if it is already 1");
        System.out.println("Index here starts from left side");
        int number=10;
        System.out.println("Number:  "+number);
        System.out.println("Binary representation:  "+Integer.toBinaryString(number));
        System.out.println("Answer:  "+set(number,4));

    }
    static String set(int number,int index){
        int len=Integer.toBinaryString(number).length();
        if(len <= index) return "Index out of bound";
        int mask=1;
        mask<<=index;
        number|=mask;
        return Integer.toBinaryString(number);
    }
}
