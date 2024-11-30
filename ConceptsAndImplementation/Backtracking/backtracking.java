package Backtracking;

import java.util.Arrays;

public class backtracking {
    public static void main(String[] args) {
        boolean[][] arr=new boolean[3][3];
        int[][] path=new int[3][3];
        exploreAllPaths(0,0,1,arr,"",path);

    }

    //D R U L(down,right,up,left)
    static void exploreAllPaths(int r,int c,int step,boolean[][] metaData,String path,int[][] pathArray){
        if(r == metaData.length-1 && c == metaData[0].length-1){
            System.out.println("Path--> "+path+"  Total steps: "+(step-1));
            for(int i=0;i<pathArray.length;i++){
                System.out.println(Arrays.toString(pathArray[i]));
            }
            return;
        }
        if(metaData[r][c] == true) return;
        //Taking marsk as visited while finding path
        metaData[r][c] = true;
        pathArray[r][c]=step;
        //Exploring 4 direction from current position
        if(r>0) exploreAllPaths(r-1,c,step+1,metaData,path+'U',pathArray);
        if(r< metaData.length-1) exploreAllPaths(r+1,c,step+1,metaData,path+'D',pathArray);
        if(c>0) exploreAllPaths(r,c-1,step+1,metaData,path+'L',pathArray);
        if(c<metaData[0].length-1) exploreAllPaths(r,c+1,step+1,metaData,path+'R',pathArray);
        //Restoring the path for another calls
        metaData[r][c] = false;
        pathArray[r][c]=0;


    }
}
