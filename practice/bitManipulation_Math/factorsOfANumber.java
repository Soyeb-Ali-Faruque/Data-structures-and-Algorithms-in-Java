package bitManipulation_Math;

import java.util.ArrayList;

public class factorsOfANumber {
    public static void main(String[] args) {
        findFactors_optimized(28);

    }


    //Time Complexity --> O(n)
    //Space Complexity --> O(1)
    static void findFactors(int number) {
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.print(i + "  ");
            }
        }
        System.out.print(number);
    }


    //Time Complexity --> O(root(n))
    //Space Complexity --> O(root(n))
    static void findFactors_optimized(int number) {
        ArrayList<Integer> remainingFactor = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.print(i + "  ");
                if (number / i == i) continue;
                remainingFactor.add(number / i);
            }
        }
        for (int i = remainingFactor.size() - 1; i >= 0; i--) {
            System.out.print(remainingFactor.get(i) + "  ");
        }
    }
}
