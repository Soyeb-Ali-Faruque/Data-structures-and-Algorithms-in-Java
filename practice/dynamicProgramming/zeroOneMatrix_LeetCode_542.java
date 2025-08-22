package dynamicProgramming;

import java.util.Arrays;

public class zeroOneMatrix_LeetCode_542 {
    class Solution {

        //partially passed testcases
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n =mat[0].length;
            int[][] dp = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int[] row : dp) Arrays.fill(row,-1);
            for(int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    nearestDistance(mat,dp,visited,i,j);
                }
            }
            return dp;
        }
        private int nearestDistance(int[][] mat,int[][] dp,boolean[][] visited,int r,int c){
            if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) return Integer.MAX_VALUE;
            if(dp[r][c] != -1) return dp[r][c];
            if(visited[r][c]) return Integer.MAX_VALUE;
            visited[r][c] = true;
            if(mat[r][c] == 0){
                dp[r][c] = 0;
            }else {
                int minDistance = Integer.MAX_VALUE;
                //up
                int calculatedDistance = nearestDistance(mat, dp,visited, r - 1, c);
                minDistance = Math.min(minDistance, calculatedDistance);

                //right
                calculatedDistance = nearestDistance(mat, dp,visited, r, c + 1);
                minDistance = Math.min(minDistance, calculatedDistance);

                //down
                calculatedDistance = nearestDistance(mat, dp,visited, r + 1, c);
                minDistance = Math.min(minDistance, calculatedDistance);

                //left
                calculatedDistance = nearestDistance(mat, dp,visited, r, c - 1);
                minDistance = Math.min(minDistance, calculatedDistance);

                dp[r][c] = 1 + minDistance;
            }

            return dp[r][c];
        }

    }

}
