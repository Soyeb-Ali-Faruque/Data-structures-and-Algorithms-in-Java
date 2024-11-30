package recursion;

import java.util.ArrayList;
import java.util.List;

public class mazeProblem {
    public static void main(String[] args) {
        System.out.println(exploreInclusive("",3,3));

    }

    //count total ways to reach end element of 2d array
    static int explore(int r,int c){
        if(r == 1 || c == 1) return 1;
        return explore("",r-1,c) + explore(r,c-1);
    }

    //print all the paths and total paths as count
    static int explore(String path,int r,int c){
        if(r == 1 && c == 1) {
            System.out.print(path+"  ");
            return 1;
        }
        if(r == 1) return explore(path+'R',r,c-1);
        if(c == 1) return explore(path+'D',r-1,c);
        return explore(path+'D',r-1,c) + explore(path+'R',r,c-1);
    }

    //exclusive storage for path
    static void explore(List<String> str,String path, int r, int c){
        if(r == 1 && c == 1){
            str.add(path);
            return;
        }
        if(r == 1) {
            explore(str,path+'R',r,c-1);
            return;
        }
        if(c == 1) {
            explore(str,path+'D',r-1,c);
            return;
        }
        explore(path+'D',r-1,c);
        explore(path+'R',r,c-1);

    }

    //Inclusive storage for path
    static List<String> exploreInclusive(String path,int r,int c){
        List<String> ans=new ArrayList<>();
        if(r == 1 && c == 1){
             ans.add(path);
             return ans;
        }
        if(r == 1) {
            ans.addAll(exploreInclusive(path+'R',r,c-1));
            return ans;
        }
        if(c == 1) {
            ans.addAll(exploreInclusive(path+'D',r-1,c));
        return ans;
        }
        ans.addAll(exploreInclusive(path+'D',r-1,c));
        ans.addAll(exploreInclusive(path+'R',r,c-1));
        return ans;
    }



}
