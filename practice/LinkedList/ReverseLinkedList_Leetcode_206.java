package LinkedList;

public class ReverseLinkedList_Leetcode_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode node=recursive_reverse(head);
        head.next=null;
        return node;
    }
    ListNode recursive_reverse(ListNode head){
        if(head.next == null) {
            return head;
        }
        ListNode node=recursive_reverse(head.next);
        head.next.next=head;
        return node;
    }
}
