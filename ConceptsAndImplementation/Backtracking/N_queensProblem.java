package Backtracking;

import java.util.Arrays;

public class N_queensProblem {
    public static void main(String[] args) {
        int queens=5;
        boolean board[][]=new boolean[queens][queens];
        System.out.println( placeQueens(board,0,0));

    }
    static int placeQueens(boolean[][] board,int r,int count){
        if(r == board.length){
//            printQueens(board);
            count++;
            return count;
        }
        for(int i=0;i<board.length;i++){
            //backtract logic with calls
            if(isSafe(board,r,i)){
                board[r][i] = true;
               count= placeQueens(board,r+1,count);
                board[r][i] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        int row=r;
        for(int i=r-1;i>=0;i--){
            if(board[i][c] == true) return false;
        }
        for(int i=c+1;i<board.length;i++){
            if(--r>=0 && board[r][i] == true ) return false;
        }
        r=row;
        for(int i=c-1;i>=0;i--){
            if(--r>=0 && board[r][i] == true) return false;
        }
        return true;
    }

    private static void printQueens(boolean[][] board) {
        for(int i=0;i< board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

}
