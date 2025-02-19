package Array;

public class Flipping_anImage_LeetCode_832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int row=image.length;
        int col= 0;
        if( (row & 1) == 1){
            col=row/2;
        }else{
            col=(row/2) -1;
        }


        for(int i=0;i<row;i++){
            for(int j=0;j<=col;j++){
                //swap and xor with one
                int temp=image[i][j];
                image[i][j]=1^image[i][row-1-j];
                image[i][row-1-j]=1^temp;
            }
        }
        return image;
    }
}
