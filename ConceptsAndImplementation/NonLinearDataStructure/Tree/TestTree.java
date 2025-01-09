package NonLinearDataStructure.Tree;

public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree =new BinarySearchTree<>();
        int[] array={12,10,9,6,5,4,3,2,1,15,16,17,18,19};
        BinarySearchTree<Integer> tree1=new BinarySearchTree<>();
        tree1.insert(10);
        tree1.insert(8);
        tree1.insert(4);
        tree1.insert(2);
        tree1.insert(9);
        tree1.insert(15);
        tree1.insert(12);
        tree1.insert(18);

        for(int i=0;i<array.length;i++){
            tree.insert(array[i]);
        }
        System.out.println(tree.getTreeheight());
        System.out.println(tree1.getTreeheight());






    }
}
