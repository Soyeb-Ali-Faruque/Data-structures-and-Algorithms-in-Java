package bitManipulation_Math;

public class findUniqueNumber_inEvenArray {
    public static void main(String[] args) {
        int[] Test={2,2,5,4,4,4,2,4,2};
        System.out.println(findUnique(Test));

    }
    static int findUnique(int[] array){
        int ans=0;
        for(int i=0;i<array.length;i++){
            ans^=array[i];
        }
        return ans;
    }
}
