package bitManipulation_Math;

public class findSquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(40,0.000000001));


    }



    //Time Complexity --> O(log(number))
    //Space Complexity --> O(1)
    static int perfectSquareRoot(int number){
        int start =2;
        int end =number;
        while(start <= end ){
            int mid= start + (end-start)/2;
            if(mid*mid == number){
                return  mid;
            }
            if(mid*mid > number) end=mid-1;
            else start = mid + 1;

        }
        return -1;
    }


    //Time Complexity --> O(log(number)+digits)
    //Space Complexity --> O(1)
    static double non_perfectSquareRoot(int number,int digits){
        double ans=0;
        if (perfectSquareRoot(number) >=0) return -1;
        int start=0;
        int end= number;
        while(start <=end){
            int mid=start + (end- start)/2;
            if(mid * mid > number) end = mid-1;
            else start= mid +1;
        }
        ans=end;
        double dc =1;

        for(int i=1;i<=digits;i++){
            dc/=10;
            ans+=dc;
            while(ans*ans <= number){
                ans+=dc;
            }
            ans-=dc;
        }
        return ans;
    }


    //Newton's Raphson Method
    static double squareRoot(double number,double accuracy){
        double root;
        double x=number;
        while(true){
            root=  (x + ( number/x)) * 0.5;
            if(Math.abs(root-x) < accuracy) break;
            x=root;

        }
        return root;
    }

}
