package LinkedList;

public class RemoveLinkedListElements_Leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode prev=null;
        ListNode current=head;
        while(current != null) {
            if (current.val == val) {
                //remove logic for deletion from starting point
                if (prev == null) {
                    head = current.next;
                }
                //remove logic for normal deletion
                else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
