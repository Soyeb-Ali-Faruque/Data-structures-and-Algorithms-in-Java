package recursion;

import java.util.Arrays;

 class reverse_character {
    public static void main(String[] args) {
        char[] Test={'s','o','y','e','b','a'};
        int s=0;
        int e=Test.length-1;
        System.out.println(Arrays.toString(reverseString(Test,s,e)));
    }



     //Time complexity --> O(n)
     //Space complexity --> O(n)
     static char[] reverseString(char[] arr,int s,int e) {
        if(s == e || s > e) return arr;
        //swap
         char temp=arr[e];
         arr[e]=arr[s];
         arr[s]=temp;
         //call
         return reverseString(arr,s+1,e-1);
    }
}
