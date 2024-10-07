package bitManipulation_Math;

public class findPrimesNumbersInRange {
    public static void main(String[] args) {
        primeNumbersRangeOf(10,30);
        primeNumbersRangeOf_optimized(10,30);
    }

    //Time Complexity --> O(number * root(number))
    //Space Complexity --> O(1)
    static void primeNumbers(int number){
        System.out.println("Prime Numbers From 2 to "+number);
        for(int i=2;i<=number;i++){
            if(checkPrimeNumber.isPrime(i)){
                System.out.println(i);
            }
        }
    }


    //Time Complexity --> O((b-a) * root(b))
    //Space Complexity --> O(1)
    static void primeNumbersRangeOf(int a,int b){
        System.out.println("Prime Numbers From "+a+" to "+b);
        for(int i=a;i<=b;i++){
            if(checkPrimeNumber.isPrime(i)){
                System.out.println(i);
            }
        }
    }


    // Sieve Of Eratosthenes
    //Time Complexity --> O(number * log(log(number)))
    //Space Complexity --> O(number)
    static void primeNumbers_optimized(int number) {
        boolean[] array = new boolean[number + 1];
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (array[i] == false) {
                for (int j = i * 2; j <= number; j += i) {
                    array[j] = true;
                }
            }
        }
        System.out.println("Prime Numbers From 2 to " + number + " Optimized");
        for (int i = 2; i <= number; i++) {
            if (array[i] == false) {
                System.out.println(i);
            }
        }
    }


    //Time Complexity --> O(b * log(log(b)))
    //Space Complexity --> O(n) // n= (b-a)+1
    static void primeNumbersRangeOf_optimized(int a,int b){
        int size=(b - a)+1;
        boolean[] array = new boolean[size];
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (array[i-2] == false) {
                for (int j = i * 2; j <=b; j += i) {
                    if(j>=a) {
                        array[j - a] = true;
                    }
                }
            }
        }
        System.out.println("Prime Numbers From "+a+" to " + b + " Optimized");
        for (int i = a; i <= b; i++) {
            if (array[i-a] == false) {
                System.out.println(i);
            }
        }
    }



}
