package LinearDataStructures.LinkedList;

public class TestMain_linkedList {
    public static void main(String[] args) {
        singlyLinkedList<Integer> test=new singlyLinkedList<>();
        test.addFirst(10);
        test.addFirst(20);
        test.addFirst(30);
        test.addFirst(40);
        test.addFirst(50);
        test.addLast(50);
        test.addAt(3,25);

        test.display();
    }
}
