package LinearDataStructures.LinkedList;

public class singlyLinkedList<E>{
    private int size=0;
    Node head=null;
    //Insertions
    void addFirst(E data){
        Node node=new Node(data);
        if(!(size == 0)) node.next=head;
        head=node;
        size++;
    }
    void addLast(E data){
        Node temp=head;
        if(temp == null){
            addFirst(data);
            return;
        }
        size++;

            //go till the end
            while (temp.next != null) {
                temp = temp.next;
            }
            Node node=new Node(data);
            temp.next=node;

    }
    void addAt(int index,E data){
        if(size == 0){
            addFirst(data);
        }else if(size <= index){
            addLast(data);
        }else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            Node node=new Node(data);
            node.next=temp.next;
            temp.next=node;
            size++;
        }
    }
    //deletion
    int removeFirst(){
        if(size == 0) return -1;
        size--;
        int data=head.next;
        head=head.next;
        return data;
    }
    int removeLast(){
        if(size == 0) return -1;
        size--;
        Node temp=head;
        for(int i=0;i<size-1;i++){
            temp=temp.next;
        }


    }
    void display(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    //fetch
    int getFirst(){
        if(size == 0) return -1;
        return head.data;
    }
    int getlast(){
        if(size == 0) return -1;
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        return temp.data;
    }
    int get(int index){
        if(size == 0 || size<index) return -1;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    //utility methods
    int size(){
        return this.size;
    }
    boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    private int findByData(E data){
        int index=0;
        Node temp=head;
        while(temp !=null){
            if(temp.data == data) return index;
            temp=temp.next;
        }
        return -1;
    }
    boolean contains(E data){
        if(findByData(data) == -1) return false;
        return true;
    }
    int indexOf(E data){
        return findByData(data);
    }
    void clear(){
        head=null;
    }






        class Node{
            private E data;
            Node next=null;
            Node(E data){
                this.data=data;
            }







        }
    }

