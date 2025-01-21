package Sorting;

import NonLinearDataStructure.Tree.Heap;

import java.util.ArrayList;

public class heapSort {
    public static ArrayList<Integer> heapSort(ArrayList<Integer> array){
        //create heap
        Heap<Integer> heap=new Heap<>();
        heap.buildHeap(array);
        for(int i=0;i<array.size();i++){
            array.set(i, heap.remove());
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList<>();
        array.add(20);
        array.add(27);
        array.add(21);
        array.add(23);
        array.add(10);
        array.add(2);
        array.add(5);
        array.add(12);
        array.add(60);
        ArrayList<Integer> sorted_array=heapSort(array);
        System.out.println(sorted_array);


    }
}
