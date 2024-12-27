package Backtracking;

import java.util.Arrays;

public class sudoku9X9problem {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(board,0,0,false);
//        System.out.println(isSafe(board,0,2,1));
        System.out.println("original array");
        display(board);

       }

    static boolean solve(char[][] board,int r,int c,boolean solved){
        if(c==board.length){
            r=r+1;
            c=0;
        }
        if(r == board.length){
            display(board);
            return true;
        }
        if(board[r][c] == '.'){
        for(int i=1;i<=9;i++){
            char ch = (char) (i + '0');
            if(isSafe(board,r,c,ch)) {
                //backtract
                board[r][c] = ch;
                solved= solve(board, r, c + 1,false);
                if(solved) break;
                board[r][c] = '.';

            }

        }
        }else{
             solved= solve(board,r,c+1,false);
        }
        return solved;

    }

    static boolean isSafe(char[][] board,int r,int c,char ch){
        //find in row
        for(int i=0;i<board.length;i++){
            if(i==c) continue;
            if(board[r][i] == ch) return false;
        }
        //find int col
        for(int i=0;i<board.length;i++) {
            if (i == r) continue;
            if (board[i][c] == ch) return false;
        }
        //find in sub part
        int x=setIndex(r);
        int y=setIndex(c);
        for(int i=x;i<x+3;i++ ){
            for(int j=y;j<y+3;j++ ){
                if(board[i][j] == ch) return false;
            }
        }

        return true;
    }
    static int setIndex(int n){
        if(n < 3) return 0;
        if(n < 6) return 3;
        return 6;
    }

    static void display(char[][] board){
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
