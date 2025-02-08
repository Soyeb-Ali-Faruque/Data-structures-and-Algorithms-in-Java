package LinkedList;

public class DesignLinkedList_Leetcode_707 {
    public static void main(String[] args) {
        MyLinkedList test=new MyLinkedList();
        test.addAtHead(1);
        test.addAtTail(3);
        test.addAtIndex(1,2);
        test.deleteAtIndex(1);
        System.out.println(test.get(1));

    }
   static  class MyLinkedList {
         class Node{
            int val;
            Node next;
            Node(int val){
                this.val=val;
            }

        }
        int size=0;
        Node head;
        Node tail;

        void print(){
            Node temp=head;
            while(temp != null){
                System.out.println(temp.val);
                temp=temp.next;
            }
        }

        public MyLinkedList() {

        }

        public int get(int index) {
            if(size == 0 || index >= size) return -1;
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }return temp.val;

        }

        private void addEmptyList(int val){
            Node node =new Node(val);
            head=node;
            tail=node;

        }

        public void addAtHead(int val) {

            if(head == null) addEmptyList(val);
            else{
                Node node=new Node(val);
                node.next=head;
                head=node;
            }
            size++;
        }

        public void addAtTail(int val) {
            if(tail == null) addEmptyList(val);
            else{
                Node node=new Node(val);
                tail.next=node;
                tail=node;
            }
            size++;
        }



    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) addAtTail(val);
        else if(index == 0) addAtHead(val);
        else{
            Node current=null;
            Node next=head;
            for(int i=0;i<index;i++){
                current = next;
                next=next.next;

            }
            Node node =new Node(val);
            current.next=node;
            node.next=next;
            size++;
        }


    }

    private void deleteAtFirst(){
            head=head.next;
            size--;
    }
    public void deleteAtIndex(int index) {
            if(index >= size || size == 0) return;
            if(index == 0) deleteAtFirst();
            else {
                Node current = null;
                Node next = head;
                for (int i = 0; i < index; i++) {
                    current = next;
                    next = next.next;
                }
                current.next = next.next;
                size--;
            }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
