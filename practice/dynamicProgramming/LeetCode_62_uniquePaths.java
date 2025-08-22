package dynamicProgramming;

public class LeetCode_62_uniquePaths {
    private int countPaths(int i,int j,int[][] dp){
        if(i >= dp.length || j >= dp[0].length) return 0;
        if( i == dp.length-1 && j == dp[0].length-1) return 1;
        if(dp[i][j] != 0) return dp[i][j];
        int down = countPaths(i+1,j,dp);
        int right = countPaths(i,j+1,dp);
        dp[i][j] = down + right;
        return dp[i][j];
    }

    private int countPaths(int i,int j,int m,int n){
        if(i > m || j > n) return 0;
        if(i ==m && j == n) return 1;
        int down = countPaths(i+1,j,m,n);
        int right=countPaths(i,j+1,m,n);
        return down + right;
    }
}
