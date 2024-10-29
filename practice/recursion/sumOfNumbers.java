package recursion;

public class sumOfNumbers {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    //Time complexity --> O(n)
    //Space complexity --> O(n)
    static int sum(int number){
        if(number == 1) return 1;
        return number+sum(number-1);
    }
}
