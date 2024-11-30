package recursion;

public class subset_printAllsubset {
    public static void main(String[] args) {
        print("","abc");
    }
    static void print(String a,String b){
        if(b.length() == 0){
            System.out.println(a);
            return;}
        print(a+b.charAt(0),b.substring(1));
        print(a,b.substring(1));
    }
}
