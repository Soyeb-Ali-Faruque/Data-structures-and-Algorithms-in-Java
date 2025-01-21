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
    private void swap(int index1,int index2){
        E temp=heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }

    private int leftChildIndex(int parentIndex){
        return (parentIndex*2 + 1);
    }
    private int rightChildIndex(int parentIndex){
        return ((parentIndex*2) + 2);
    }
    private int getParentIndex(int childIndex){
        return (childIndex - 1)/2;
    }
    private boolean hasParent(int childIndex){
        return (childIndex != 0)? true:false;
    }
    private boolean hasLeftChild(int parentIndex){
        int leftChildIndex=parentIndex*2 + 1;
        return (leftChildIndex < heap.size())? true: false;
    }
    private boolean hasRightChild(int parentIndex){
        int rightChildIndex=parentIndex*2 + 2;
        return (rightChildIndex < heap.size())? true: false;
    }
    private void heapifyDown(int parentIndex){
        if ((!hasLeftChild(parentIndex)) && (!hasRightChild(parentIndex)) || size() == 0) return;

        //variables
        E parent = heap.get(parentIndex);
        E leftChild=null;
        E rightChild=null;
        if(hasLeftChild(parentIndex)){
            leftChild=heap.get(leftChildIndex(parentIndex));

        } if (hasRightChild(parentIndex)) {
            rightChild=heap.get(rightChildIndex(parentIndex));
        }

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
    private void heapifyUp(int childIndex){
        if(!hasParent(childIndex)) return;
        int parentindex=getParentIndex(childIndex);
        E parent = heap.get(parentindex);
        E child = heap.get(childIndex);
        if(parent.compareTo(child) >= 0) return;
        swap(parentindex,childIndex);
        heapifyUp(parentindex);
    }


    //user methods
    public boolean isEmpty(){
        return (heap.size() == 0)? true:false;
    }

    public void clear(){
        heap=new ArrayList<>();
    }

    public int size(){
        return heap.size();
    }

    public E peek(){
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

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
    public void insert(E data){
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    public String toString(){
        return String.valueOf(heap);
    }

    public void   buildHeap(ArrayList<E> array){
        for(int i=0;i< array.size();i++){
            insert(array.get(i));
        }
    }




}
