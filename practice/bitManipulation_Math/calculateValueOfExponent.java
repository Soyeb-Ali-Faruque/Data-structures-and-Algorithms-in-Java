package bitManipulation_Math;

public class calculateValueOfExponent {
    public static void main(String[] args) {
        System.out.println(calculate_optimized(3,2));
    }

    //Time Complexity --> O(power)
    //Space Complexity --> O(1)
    static int calculate(int number,int power){
        int ans=1;
        for(int i=0;i<power;i++){
            ans*=number;
        }
        return ans;

    }

    //Time Complexity --> O(log(power))
    //Space Complexity --> O(1)
    static int calculate_optimized(int number,int power){
        int ans=1;
        int base=number;
        while(power>0){
            if((power & 1) == 1){
                ans*=base;
            }
            base*=base;
            power>>=1;
        }
        return ans;
    }
}
