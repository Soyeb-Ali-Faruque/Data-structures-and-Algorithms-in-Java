package NonLinearDataStructure.Tree;

public class AVLTree<E extends Number & Comparable<E>>  {
    class Node{
        E data;
        int height=-1;
        Node left=null;
        Node right=null;

        //constructor
        Node(E data){
            this.data=data;
        }
        public String toString(){
            return String.valueOf(data);
        }
    }

    Node root;

    //insertion
    public void insert(E data) {
    }







}
