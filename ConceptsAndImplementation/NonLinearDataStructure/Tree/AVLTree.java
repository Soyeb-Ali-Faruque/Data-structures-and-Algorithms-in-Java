package NonLinearDataStructure.Tree;

public class AVLTree<E extends Number & Comparable<E>> extends BinarySearchTree<E>  {
    //constructor




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
