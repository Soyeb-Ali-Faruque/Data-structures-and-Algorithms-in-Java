package NonLinearDataStructure.Tree;

import java.util.ArrayList;

public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
        tree.inorderTraversal();
        System.out.println();
        tree.delete(40);
        tree.inorderTraversal();
        System.out.println();
        tree.delete(30);
        tree.inorderTraversal();
        System.out.println();
        tree.delete(20);
        tree.inorderTraversal();













    }
}
