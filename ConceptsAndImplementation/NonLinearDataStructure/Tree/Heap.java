package NonLinearDataStructure.Tree;

import java.util.ArrayList;

/**  this code sample implementation is based on maxHeap
 * where higher integer value or number is followed to be stored at root */
public class Heap<E extends Number & Comparable<E>> {
    private ArrayList<E> heap;
    public Heap(){
        heap=new ArrayList<E>();
    }


    //Internal methods

    //swap to object in the ArrayList
    private void swap(int index1,int index2){
        E temp=heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }

    //get left child object index
    private int leftChildIndex(int parentIndex){
        return (parentIndex*2 + 1);
    }

    //get right child object index
    private int rightChildIndex(int parentIndex){
        return ((parentIndex*2) + 2);
    }

    //get parent object index
    private int getParentIndex(int childIndex){
        return (childIndex - 1)/2;
    }

    //returns true if child object has parent in the ArrayList
    private boolean hasParent(int childIndex){
        return (childIndex != 0)? true:false;
    }

    //returns true if parent has left child object
    private boolean hasLeftChild(int parentIndex){
        int leftChildIndex=parentIndex*2 + 1;
        return (leftChildIndex < heap.size())? true: false;
    }

    //returns true if parent has right child object
    private boolean hasRightChild(int parentIndex){
        int rightChildIndex=parentIndex*2 + 2;
        return (rightChildIndex < heap.size())? true: false;
    }


    //balancing the heap property while remove operation happen
    private void heapifyDown(int parentIndex){
        //return if this is leaf node
        if ((!hasLeftChild(parentIndex)) && (!hasRightChild(parentIndex)) || size() == 0) return;

        //variables
        E parent = heap.get(parentIndex);
        E leftChild=null;
        E rightChild=null;

        //checking and assigning value of childs
        if(hasLeftChild(parentIndex)){
            leftChild=heap.get(leftChildIndex(parentIndex));

        } if (hasRightChild(parentIndex)) {
            rightChild=heap.get(rightChildIndex(parentIndex));
        }

        //Recursive comparision between parent and its childs
        if(hasRightChild(parentIndex) && hasLeftChild(parentIndex)){
            if(parent.compareTo(leftChild) >= 0 && parent.compareTo(rightChild) >= 0) return;
            if(leftChild.compareTo(rightChild)>=0) {
                swap(parentIndex,leftChildIndex(parentIndex));
                heapifyDown(leftChildIndex(parentIndex));
            }else{
                swap(parentIndex,rightChildIndex(parentIndex));
            }

        } else if (hasLeftChild(parentIndex)) {
            if(parent.compareTo(leftChild) >= 0) return;
            else{
                swap(parentIndex,leftChildIndex(parentIndex));
                heapifyDown(leftChildIndex(parentIndex));

            }

        }else{
            if(parent.compareTo(rightChild) >= 0) return;
            else{
                swap(parentIndex,rightChildIndex(parentIndex));
                heapifyDown(rightChildIndex(parentIndex));

            }

        }

    }


    //balancing the heap property when insertions happen
    private void heapifyUp(int childIndex){
        //return if at root object
        if(!hasParent(childIndex)) return;

        //recursive comparision
        int parentindex=getParentIndex(childIndex);
        E parent = heap.get(parentindex);
        E child = heap.get(childIndex);
        if(parent.compareTo(child) >= 0) return;
        swap(parentindex,childIndex);
        heapifyUp(parentindex);
    }



    //user methods

    //returns true if empty heap is there
    public boolean isEmpty(){
        return (heap.size() == 0)? true:false;
    }

    //remove all the object from the heap
    public void clear(){
        heap=new ArrayList<>();
    }

    //return the length of the heap
    public int size(){
        return heap.size();
    }

    //return root element
    public E peek(){
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    //remove and return root element
    public E remove(){
        if(heap.isEmpty()) return null;
        E root=heap.get(0);
        E temp=heap.removeLast();
        if(!heap.isEmpty()){
            heap.set(0,temp);
            //heapify down
            heapifyDown(0);
        }

        return root;
    }

    //insertion of an object to the heap
    public void insert(E data){
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    //build heap from an array
    public void   buildHeap(ArrayList<E> array){
        for(int i=0;i< array.size();i++){
            insert(array.get(i));
        }
    }


    @Override
    public String toString(){
        return String.valueOf(heap);
    }






}
