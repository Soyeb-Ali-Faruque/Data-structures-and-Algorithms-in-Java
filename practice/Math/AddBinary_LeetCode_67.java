package Math;

public class AddBinary_LeetCode_67 {
    public String addBinary(String a, String b) {
        String ans="";
        int c=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0 && j>=0){
            int x=a.charAt(i--) - '0';
            int y=b.charAt(j--) - '0';
            int xor=x ^ y ^ c;
            ans=xor+ans;
            if((x+y+c) >=2) c=1;
            else c=0;
        }
        while(i>=0){
            int x=a.charAt(i--) - '0';
            int xor=x^c;
            ans=xor+ans;
            if((x+c) == 2) c=1;
            else c=0;
        }
        while(j>=0){
            int y=b.charAt(j--) - '0';
            int xor=y^c;
            ans=xor+ans;
            if((y+c) == 2) c=1;
            else c=0;
        }
        if(c == 1) ans=c+ans;
        return ans;
    }
}
