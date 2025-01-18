package LinkedList;

public class RemoveDuplicatesFromSortedList_Leetcode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode temp=head;
        ListNode node=head;
        while(temp.next!= null){
            if(node.val != temp.val) {
                node.next=temp;
                node=temp;
            }

            temp=temp.next;
        }
        if(node.val == temp.val){
            node.next=null;
        }else{
            node.next = temp;
        }
        return head;

    }
}
