package BitManipulation;

import java.util.ArrayList;

public class findUniqueNumber_inOddArray {
    public static void main(String[] args) {
//        int[] array={2,3,2,7,7,8,8};
//        System.out.println(findUniqueNumber(array,2));
        System.out.println(-4);
        System.out.println(~(-4) +1);

    }

    //Time Complexity --> O(n*log(n))
    //Space Complexity --> O(log(n))
    static int findUniqueNumber(int[] array,int T){
        //ans array list
        ArrayList<Integer> ans=new ArrayList<>();
        // storing frequency of set bits
        for(int j=0;j<array.length;j++){
            int index=0;
            String str=Integer.toBinaryString(array[j]);
            for(int i=str.length()-1;i>=0;i--){
                int number=str.charAt(i) - '0';
                if(index == ans.size()){
                    //add element
                    ans.add(number);
                }else{

                    number+=ans.get(index);
                    ans.set(index,number);
                }index++;
            }
        }

        //Removing odd appearance numbers
        for(int i=0;i<ans.size();i++){
            ans.set(i,(ans.get(i) % T));
        }
        //Regenrating the unique number from the array list
        int power=0;
        int answer=0;
        for(int i =0;i<ans.size();i++){

            answer+=(ans.get(i) * (int)Math.pow(2,power++));

        }
        return answer;
    }
}
