package recursion;

public class is_arraySorted {
    public static void main(String[] args) {
        int[] Test1={1,3,2,4,5};
        System.out.println(check(Test1,0));

    }
    static boolean check(int[] array,int i){
        if(array.length-1 == i) return true;
        return (array[i]<array[i+1]) && check(array,i+1);
    }
}
