package NonLinearDataStructure.Tree;

public class TestTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree =new AVLTree<>();
        int[] array={4, 2, 6, 1, 3, 5, 7};

        for(int i=0;i< array.length;i++){
            tree.insert(array[i]);
        }

        System.out.println(tree.isTreeBalanced());








    }
}
