package LinearDataStructures.LinkedList;

public class singlyLinkedList<E>{
    private int size=0;
    Node head=null;
    //Insertions
    void add(E data){
        addLast(data);
    }
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
    E remove(){
        return removeLast();

    }
    E removeFirst(){
        if(size == 0) return null;
        size--;
        E data=head.data;
        head=head.next;
        return data;
    }
    E removeLast(){
        if(size == 0) return null;
        size--;
        Node temp=head;
        for(int i=0;i<size-1;i++){
            temp=temp.next;
        }
        E data = temp.next.data;
        temp.next=null;
        return data;
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
    E getFirst(){
        if(size == 0) return null;
        return head.data;
    }
    E getlast(){
        if(size == 0) return null;
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        return temp.data;
    }
    E get(int index){
        if(size == 0 || size<index) return null;
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

    Node middleNode(){
        if(size == 0){
            Node node=new Node(null);
        }
        int mid=size/2;
        Node temp=head;
        for(int i=0;i<mid;i++){
            temp=temp.next;
        }
        return temp;
    }
    singlyLinkedList merge(singlyLinkedList<E> other){
        Node temp=this.head;
        if(temp == null){
            this.head=other.head;
            return this;
        }
        //go till the end
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=other.head;
        return this;
    }
    E findNthFromEnd(int index){
        index=size-index;
        return get(index);
    }






    public String toString(){
        this.display();
        return "";
    }




        class Node{
            private E data;
            Node next=null;
            Node(E data){
                this.data=data;
            }
            public String toString(){
                return (" DATA : "+data);
            }
        }
    }

