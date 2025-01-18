package LinkedList;

public class LinkedListCycle_Leetcode_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null ) return false;
        ListNode fast=head;
        ListNode slow=head;
        do{
            if(fast.next != null) fast=fast.next.next;
            else fast=fast.next;
            slow=slow.next;
            if(fast == slow) return true;

        }while(fast != null);
        return false;

    }
}
