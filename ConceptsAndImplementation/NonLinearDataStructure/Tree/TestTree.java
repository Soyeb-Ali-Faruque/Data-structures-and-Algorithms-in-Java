package NonLinearDataStructure.Tree;

import java.util.ArrayList;

public class TestTree {
    public static void main(String[] args) {
        Heap<Integer> heap=new Heap<>();

        ArrayList<Integer> array=new ArrayList<>();
        array.add(10);
        array.add(20);
        array.add(30);
        heap.buildHeap(array);

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());









    }
}
