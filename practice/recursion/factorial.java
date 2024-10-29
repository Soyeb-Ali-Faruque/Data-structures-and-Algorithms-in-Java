package recursion;

public class factorial {
    public static void main(String[] args) {
        System.out.println(calculate_factorial(3));

    }

    //Time complexity --> O(n)
    //Space complexity --> O(n)
    static int  calculate_factorial(int n){
        if(n ==1) return 1;
        return n*calculate_factorial(n-1);
    }
}
