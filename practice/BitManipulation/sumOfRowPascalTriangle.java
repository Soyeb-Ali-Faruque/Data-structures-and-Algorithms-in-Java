package BitManipulation;

public class sumOfRowPascalTriangle {
    public static void main(String[] args) {
        System.out.println(sum(3));
    }


    //Time Complexity --> O(1)
    //Space Complexity --> O(1)
    static int sum(int row){
        return 1<<row;
    }
}
