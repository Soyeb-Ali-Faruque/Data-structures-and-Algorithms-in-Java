package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges_LeetCode_994 {
    class Node{
        int row = -1;
        int col = -1;
        int time = 0;
        Node(int r,int c,int time){
            this.row = r;
            this.col = c;
            this.time = time;
        }
        Node(int r,int c){
            this.col = c;
            this.row = r;
        }
    }

    private int rotTime(int[][] grid){
        Queue<Node> queue = new LinkedList<>();
        //search rotten oranges to add to the queue
        for(int i =0;i< grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 2) queue.add(new Node(i,j));
            }
        }
        int time=0;
        //bfs
        while(!queue.isEmpty()){
            Node node = queue.poll();
            time = node.time;
            //update adjacent cell that may have oranges
            int row=node.row;
            int col = node.col;
            //got up down right left directions
            if(rotten(grid,row-1,col)) queue.add(new Node(row-1,col,time+1)); // up
            if(rotten(grid,row+1,col)) queue.add(new Node(row+1,col,time+1)); // down
            if(rotten(grid,row,col+1)) queue.add(new Node(row,col+1,time+1)); // right
            if(rotten(grid,row,col-1)) queue.add(new Node(row,col-1,time+1)); // left

        }

        //checkpoint if any fresh orange left
        for(int[] row : grid){
            for(int val : row){
                if(val == 1) return -1;
            }
        }

        return time;
    }
    private boolean rotten(int[][] grid,int row,int col){
        if(row < 0 || row == grid.length ) return false;
        if(col < 0 || col == grid[0].length) return false;
        int value = grid[row][col];
        if(value == 0 || value == 2) return false;
        grid[row][col] = 2;
        return true;
    }
}


