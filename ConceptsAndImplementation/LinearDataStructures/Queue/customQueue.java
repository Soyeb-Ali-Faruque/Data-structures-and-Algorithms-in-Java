package LinearDataStructures.Queue;

public class customQueue<E>{
    public String toString(){
        Element temp=first;
        System.out.print("<--");
        while(temp != null){
            System.out.print("  "+temp.element);
            temp=temp.next;
        }
        return "";
    }

   private class Element{
        Element next=null;
        E element;
        Element(E element){
            this.element=element;
        }
    }
    Element first=null;
   Element last=null;


    // Methods
    void enqueue(E element){
       Element el =new Element(element);
       if(first == null) {
           first=el;
           last=el;
           return;
       }
       last.next=el;
       last=el;
    }
    E dequeue(){
        if(first == null) return null;
        E val= first.element;
        if(first.next == null ) {
            first=null;
            last=null;
        }
        else {
            first=first.next;
        }
        return val;
    }

    E peek(){
        return first.element;
    }
    boolean isEmpty(){
        return first == null;
    }




}
