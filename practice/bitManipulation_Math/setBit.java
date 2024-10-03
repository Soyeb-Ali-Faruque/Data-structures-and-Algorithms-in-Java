package bitManipulation_Math;

public class setBit {
    public static void main(String[] args) {
        System.out.println("Set means turn the bit to 1 if it is 0 or remain 1 if it is already 1");
        System.out.println("Index here starts from right side");
        int number=10;
        System.out.println("Number:  "+number);
        System.out.println("Binary representation:  "+Integer.toBinaryString(number));
        System.out.println("Answer:  "+Integer.toBinaryString(set(number,0)));

    }

    //Time Complexity --> O(log(index))
    //Space Complexity --> O(1)
    static int set(int number,int index){
        int mask=1;
        mask<<=index;
        number|=mask;
        return number;
    }
}
