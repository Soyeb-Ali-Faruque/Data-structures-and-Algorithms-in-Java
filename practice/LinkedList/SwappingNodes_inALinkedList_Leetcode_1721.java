package LinkedList;

public class SwappingNodes_inALinkedList_Leetcode_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null) return null;
        //pointers
        ListNode fast=head;
        ListNode slow=head; //also act as kth node from the end
        ListNode wait=head;

        //counter
        int counter=1;
        while(fast.next != null){
            if(counter == k){
                if(wait == null) wait=fast;
                //move both
                slow=slow.next;
                fast=fast.next;
            }else{
                //move only fast pointer
                fast=fast.next;
                counter++;
            }
        }
        //swap
        int temp=wait.val;
        wait.val=slow.val;
        slow.val=temp;
        return head;

    }
}
