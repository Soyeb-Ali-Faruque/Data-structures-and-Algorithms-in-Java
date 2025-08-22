package Graph;

public class surroundedRegions_LeetCode_130 {
//    In summary, the algorithm runs in O(m * n) time and uses O(m * n) space.
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //boundary loops
        //horizontal loop
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O') dfs(board,visited,0,i);
            if(board[m-1][i] == 'O') dfs(board,visited,m-1,i);
        }
        //vertical loop
        for (int i =0;i<m;i++){

            if(board[i][0] == 'O') dfs(board,visited,i,0);
            if(board[i][n-1] == 'O') dfs(board,visited,i,n-1);
        }

        //after that whatever cell is there as with surrounded 0 become
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]) board[i][j] = 'X';
            }
        }



    }
    private void dfs(char[][] board,boolean[][] visited,int r,int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'X' || visited[r][c]) return;
        visited[r][c] = true;
        dfs(board,visited,r-1,c);
        dfs(board,visited,r+1,c);
        dfs(board,visited,r,c-1);
        dfs(board,visited,r,c+1);
    }

}
