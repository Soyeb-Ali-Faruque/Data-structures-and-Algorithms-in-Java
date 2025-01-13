package NonLinearDataStructure.Tree;

public class AVLTree<E extends Number & Comparable<E>>  {
    class Node{
        E data;
        int height;
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
        root=insertElement(root,data);
    }
    private Node insertElement(Node temp,E data){
        if(temp == null ) {
            Node node =new Node(data);
            node.height=0;
            return node;
        }
        if(data.compareTo(temp.data) < 0) temp.left = insertElement(temp.left,data);
        else temp.right = insertElement(temp.right,data);
        temp.height = (getNodeHeight(temp.left) > getNodeHeight(temp.right))?getNodeHeight(temp.left)+1:getNodeHeight(temp.right)+1;
        return rotate(temp);
    }

    private Node rotate(Node node){
        //4 rules to be followed for rotations
        
    }
    //Specified node height
    public int getNodeHeight(BinarySearchTree.Node node){
        if(node ==null) return -1;
        return node.height;
    }







    private void rightRotate(Node node){
        Node child=node.left;
        node.left=child.right;
        child.right=node;
    }
    private void leftRotate(Node node){
        Node child=node.right;
        node.right=child.left;
        child.left=node;
    }







}
