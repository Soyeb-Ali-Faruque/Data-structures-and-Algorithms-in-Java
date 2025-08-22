package dynamicProgramming;

public class LeetCode_63_uniquePathsll {
    public static void main(String[] args) {
        int[][] array= {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePaths(0,0,array));
    }
    private static int uniquePaths(int i,int j,int[][] obobstacleGrids){
        if(i >= obobstacleGrids.length || j >= obobstacleGrids[0].length || obobstacleGrids[i][j] == 1) return 0;
        if(i == obobstacleGrids.length -1 && j == obobstacleGrids[0].length -1) return 1;
        int down = obobstacleGrids[i+1][j];
        int right = obobstacleGrids[i][j+1];
        return down+right;
    }
}
