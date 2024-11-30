package recursion;

public class trianglePattern1 {
    public static void main(String[] args) {
        create(2,1);
    }

    //Pattern

    // * * *
    //* *
    //*

    static void create(int row,int col){
      if(row == 1 ) return;
      if(col > row) {
          col = 1;
          row--;
          System.out.println();
      }
      System.out.print("* ");
      create(row,++col);
    }

}
