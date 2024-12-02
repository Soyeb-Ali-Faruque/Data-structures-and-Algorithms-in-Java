package Searching;

public class binarySearch {
    public static void main(String[] args) {

        int[] Test={1,4,6,7,8};
        System.out.println(binarySearch(Test,7));

    }

    //Time Complexity O(log(n))
    //Space Complexity O(1)
    static int binarySearch(int[] array,int target){
        int s=0;int e=array.length-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(array[mid] == target) return mid;
            if(array[mid] > target) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}
