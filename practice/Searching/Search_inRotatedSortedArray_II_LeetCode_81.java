package Searching;

public class Search_inRotatedSortedArray_II_LeetCode_81 {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(arr,2));
    }

        public static boolean search(int[] nums, int target) {

            int pivot=getPivot(nums);
            boolean found=search(nums,target,pivot,nums.length-1);
            return (found == true)?true:search(nums,target,0,pivot-1);

        }
        private static int getPivot(int[] array){
            int s=0;
            int e= array.length-1;
            while(s<e){
                int mid=s+(e-s)/2;
                if((array[mid] == array[e]) && (array[mid] == array[s])) {
                    s++;
                    e--;
                }
                else if(array[mid]>array[e]) s=mid+1;
                else e=mid;
            }
            return s;
        }
        private static boolean search(int[] array,int target,int s,int e){
            while(s<=e){
                int mid=s+(e-s)/2;
                if((array[mid] == array[e]) && (array[mid] == array[s])) {
                    s++;
                    e--;
                }
                else if(array[mid] == target) return true;
                else if(array[mid] > target) e=mid-1;
                else s=mid+1;
            }
            return false;
        }

    }

