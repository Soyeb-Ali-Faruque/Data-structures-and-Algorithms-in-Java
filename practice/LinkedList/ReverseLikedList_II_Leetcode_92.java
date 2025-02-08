package LinkedList;

public class ReverseLikedList_II_Leetcode_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        //pointers requires for reversing the linked list
        ListNode prev=null;
        ListNode current=head;
        ListNode next=head.next;

        //pointer for pointing the left-1th node
        ListNode x=null;

        //counter for managing the reversing length
        int counter=1;

        //loop
        while(next != null){
            //reverse
            if(counter >=left && counter <=right){
                current.next=prev;
                if(counter == left) x=prev;
                //connect excluded nodes for reversing when last revserse happen
                if(counter == right){
                    if(x == null) x=head;
                    ListNode tempLeftNode=x.next;
                    x.next=current;
                    tempLeftNode.next=next;
                }
            }
            counter++;
            prev=current;
            current=next;
            next=next.next;
        }
    return head;
    }
}
