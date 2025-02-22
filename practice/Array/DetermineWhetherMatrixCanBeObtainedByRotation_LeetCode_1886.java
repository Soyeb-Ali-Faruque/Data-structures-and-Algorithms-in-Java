package Array;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation_LeetCode_1886 {

        public static void main(String[] args) {
            int[][] mat = {
                    {1, 1},
                    {1, 0}
            };

            int[][] target = {
                    {1, 0},
                    {0, 1}
            };
            System.out.println(findRotation(mat,target));

        }
    public static boolean findRotation(int[][] mat, int[][] target) {
        if(check(mat,target)) return true;
        mat=rotate90(mat);
        if(check(mat,target)) return true;
        mat=rotate90(mat);
        if(check(mat,target)) return true;
        mat=rotate90(mat);
        if(check(mat,target)) return true;
        return false;

    }

    static boolean check(int[][] matrix,int[][] target){
        for(int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                if(matrix[i][j] != target[i][j]) return false;
            }

        }
        return true;
    }
    static int[][] rotate90(int[][] matrix){
        matrix=transpose(matrix);
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
        return matrix;

    }
    static int[][] transpose(int[][] matrix) {
        int[][] transpose=new int[matrix[0].length][matrix.length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                transpose[j][i]=matrix[i][j];
            }
        }

        return transpose;
    }
    static void reverse(int[] array){
        int mid=(array.length/2) - 1;
        for(int i=0;i<=mid;i++){
            int temp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=temp;
        }
    }


}
