package BitManipulation;

public class oddEven {
    public static void main(String[] args) {
        System.out.println(checkOddEven(15));

    }

    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static String checkOddEven(int number){
        if((number & 1)==0){
            return "Even";
        }
        return "Odd";
    }
}
