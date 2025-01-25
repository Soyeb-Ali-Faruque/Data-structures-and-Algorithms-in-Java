package NonLinearDataStructure.Tree;

import java.util.ArrayList;

public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree=new BinarySearchTree<>();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(13);
        tree.insert(17);
        tree.insert(25);
        tree.inorderTraversal();
        System.out.println();

        tree.delete(15);
        tree.delete(8);
        tree.delete(13);
        tree.delete(25);
        tree.insert(30);
        tree.inorderTraversal();















    }
}
