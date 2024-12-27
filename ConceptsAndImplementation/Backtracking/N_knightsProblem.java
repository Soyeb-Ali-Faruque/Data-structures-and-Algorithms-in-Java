package Backtracking;

import java.util.Arrays;

public class N_knightsProblem {
    public static void main(String[] args) {
        int k=4;
        boolean[][] board=new boolean[k][k];
        placeKnights(board,0,0,k);

    }
    static void placeKnights(boolean[][] board,int r,int c,int k){
        //found one of the answer
        if(k==0){
            printKnights(board);
            return;
        }
        if(c == board.length){
            r=r+1;
            c=0;
        }
        //end of call
        if(r == board.length) return;

        if(isSafe(board,r,c)){
            board[r][c] = true;
            placeKnights(board,r,c+1,k-1);
            board[r][c] = false;
        }
            placeKnights(board,r,c+1,k);

    }



    static boolean isSafe(boolean board[][],int r,int c){
        if(r-1 >=0){
            if((c-2 >=0) && board[r-1][c-2]) return false;
            if((c+2 < board.length)&& board[r-1][c+2]) return false;
        }
        if(r-2 >=0){
            if((c-1>=0)&&board[r-2][c-1]) return false;
            if((c+1< board.length)&& board[r-2][c+1]) return false;
        }
        return true;
    }







    private static void printKnights(boolean[][] board) {
        for(int i=0;i< board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
