package BitManipulation;
public class find_Nth_magicNumber {
    // Bit manupulation
    //2 = 1* 5^2 + 0*5^1 = magic number
    public static void main(String[] args) {
        System.out.println(magicNumber(3));

    }

    //Time Complexity --> O(log(number))
    //Space Complexity --> O(1)
    static int magicNumber(int number){
        int magic_number=0;
        int flexible_power=1;
        while(number>0) {
            magic_number += (number & 1) * (int) Math.pow(5, flexible_power++);
            number >>= 1;
        }
        return magic_number;
    }

}
