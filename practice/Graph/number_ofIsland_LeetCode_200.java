package Graph;

public class number_ofIsland_LeetCode_200 {

    //     - Time Complexity: O(m * n)
// - Space Complexity: O(m * n)
    public int numIslands(char[][] grid) {
        int island=0;
        int m= grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    island++;
                    explore(grid,i,j,visited);
                }
            }
        }
        return island;

    }
    private void explore(char[][] grid,int row,int col,boolean[][] visited){
        //base;
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length) return;
        if(grid[row][col] == '0' || visited[row][col]) return;

        //mark as visited
        visited[row][col] =  true;
        //explore all direction
        explore(grid,row-1,col,visited);
        explore(grid,row+1,col,visited);
        explore(grid,row,col+1,visited);
        explore(grid,row,col-1,visited);
    }
}
