package bitManipulation_Math;

public class findSquareRoot {
    public static void main(String[] args) {
        System.out.printf("%.3f", squareRoot(40,3));

    }
    static double squareRoot(int number,int decimalEXP){
        //Binary search
        double ans=0;
        int start=0;
        int end=(int) number;
        while(start<=end){
            int mid=start +(end-start)/2;
            ans=mid;
            if(mid * mid == number){
                return mid ;

            }else if ( mid * mid > number){
                end = mid -1;
            }else{
                start= mid + 1 ;;
            }
        }
        ans = end;
        double dcEXP= 1;

        for(int i=1;i<=decimalEXP;i++){
            dcEXP/=10;
            double dc=dcEXP;

            while((ans+dc) * (ans + dc) <=number){
                ans+=dc;
                dc+=dcEXP;
                System.out.println(dc);
            }
        }

        return ans;

    }
}
