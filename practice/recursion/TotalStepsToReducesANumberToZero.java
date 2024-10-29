package recursion;

public class TotalStepsToReducesANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123,0));
    }

    //Time complexity --> O(log(n))
    //Space complexity --> O(log(n))
    static int numberOfSteps(int num,int ans) {
        if(num == 0) return ans;
        if((num & 1) == 1 ) return numberOfSteps(num-1,++ans);
        return numberOfSteps(num/2,++ans);
    }
}
