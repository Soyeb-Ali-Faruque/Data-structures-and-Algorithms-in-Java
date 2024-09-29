package bitManipulation_Math;

public class oddEven {
    public static void main(String[] args) {
        System.out.println(checkOddEven(15));

    }
    static String checkOddEven(int number){
        if((number & 1)==0){
            return "Even";
        }
        return "Odd";
    }
}
