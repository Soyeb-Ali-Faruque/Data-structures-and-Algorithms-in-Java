package Array;

public class FindTheHighestAltitude_LeetCode_1732 {
    public int largestAltitude(int[] gain) {
        int heighestAltitude=(gain[0] < 0)? 0:gain[0];
        for(int i=1;i<gain.length;i++) {
            gain[i] += gain[i - 1];
            if (gain[i] > heighestAltitude) heighestAltitude = gain[i];
        }
        return heighestAltitude;
    }

}
