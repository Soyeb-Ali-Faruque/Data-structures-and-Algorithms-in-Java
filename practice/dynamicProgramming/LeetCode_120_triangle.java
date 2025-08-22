package dynamicProgramming;

import java.util.List;

public class LeetCode_120_triangle {


    private int getMin_optimizedMemoization(int i,int j,List<List<Integer>> list,List<List<Integer>> dp){
        if(i == list.size()) return list.get(i).get(j);
        if(dp.get(i).get(j) != Integer.MAX_VALUE) return dp.get(i).get(j);
        int down = getMin_optimizedMemoization(i+1,j,list,dp);
        int diagonal = getMin_optimizedMemoization(i+1,j+1,list,dp);
        int min = list.get(i).get(j) + Math.min(down,diagonal);
        dp.get(i).set(j,min);
        return dp.get(i).get(j);
    }

    //Time O(2^n)
    //Space O(n)
    private int getMin(int i,int j,List<List<Integer>> list){
        if(i == list.size()) return list.get(i).get(j);
        int down = getMin(i+1,j,list);
        int diagonal = getMin(i+1,j+1,list);
    return list.get(i).get(j) + Math.min(down,diagonal);
    }


}
