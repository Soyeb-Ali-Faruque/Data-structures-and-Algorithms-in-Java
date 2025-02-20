package Array;

public class MatrixDiagonalSum_LeetCode_1572 {
    public int diagonalSum(int[][] mat) {
        int diagonalSum=0;
        int n= mat.length-1;
        for(int i=0;i<=n;i++){
            int left=i;
            int right=n-i;
            if(left == right){
                diagonalSum+=mat[i][left];
            }
            else{
                diagonalSum+=mat[i][left]+mat[i][right];
            }
        }
        return diagonalSum;
    }
}
