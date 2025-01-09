package LinearDataStructures.Queue;

public class TestQueue {
    public static void main(String[] args) {
        customQueue<Integer> qu=new customQueue<>();
        System.out.println(qu.isEmpty());
        qu.enqueue(10);
        qu.enqueue(20);
        qu.enqueue(30);
        qu.enqueue(40);
        qu.enqueue(50);
        System.out.println(qu);
        qu.dequeue();
        qu.dequeue();
        System.out.println(qu);


    }
}
