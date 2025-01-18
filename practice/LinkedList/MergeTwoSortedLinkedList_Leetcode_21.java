package LinkedList;

public class MergeTwoSortedLinkedList_Leetcode_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head=null;

        // initial object need to be followed head
        if(list1.val > list2.val) {
            head=list2;
            list2=list2.next;
        }else{
            head=list1;
            list1=list1.next;

        }
        ListNode temp=head;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                temp.next=list2;
                list2=list2.next;

            }else{
                temp.next=list1;
                list1=list1.next;
            }
            temp=temp.next;
        }
        if(list1 != null) temp.next=list1;
        else temp.next = list2;

        return head;

    }
}
