package Searching;

public class ceilingOfANumber {
    public static void main(String[] args) {
        int[] Test1 = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(ceiling(Test1, 6));

    }
    static int ceiling(int[] array,int target){
        int s=0;
        int e=array.length-1;
        while(s<e){
           int mid=s + (e - s)/ 2;
            if(array[mid] >=target) e=mid;
            else s=mid+1;
        }
        if(array[s] >= target) return s;
        return -1;
    }
}
