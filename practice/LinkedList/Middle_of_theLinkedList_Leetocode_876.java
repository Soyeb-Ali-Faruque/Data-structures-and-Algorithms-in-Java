package LinkedList;

public class Middle_of_theLinkedList_Leetocode_876 {
    public ListNode middleNode(ListNode head) {
        ListNode x=head;
        ListNode y=head;
        while(y != null && y.next != null){
            x=x.next;
            y=y.next.next;
        }
        return x;
    }
}
