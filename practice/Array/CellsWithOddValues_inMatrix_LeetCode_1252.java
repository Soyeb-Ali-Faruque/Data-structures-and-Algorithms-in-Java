package Array;

public class CellsWithOddValues_inMatrix_LeetCode_1252 {
    public int oddCells(int m, int n, int[][] indices) {

        int[][] mat=new int[m][n];
        for(int i=0;i<indices.length;i++){
            //increase row wise and col wize
            int fixedRow=indices[i][0];
            int fixedCol=indices[i][1];

            for(int col=0;col<n;col++){
                mat[fixedRow][col]++;
            }

            for(int row=0;row<m;row++){
                mat[row][fixedCol]++;
            }
        }
        int ans=0;
        //find total odd value cell
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=mat[i][j];
                if((val & 1) == 1) ans++;
            }
        }
        return ans;
    }

}
