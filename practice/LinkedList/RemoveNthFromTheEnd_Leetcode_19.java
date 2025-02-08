package LinkedList;

public class RemoveNthFromTheEnd_Leetcode_19 {
//
//    Time Complexity O(n)
//        Space Complexity O(1)
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next == null) return null;
            //pointers
            ListNode fast=head;
            ListNode slow=head;
            ListNode prev=null;

            int counter=0;
            //loop
            while(true){
                if(fast == null){
                    if(prev == null){
                        head=head.next;
                    }else{
                        prev.next=slow.next;
                    }
                    break;
                }if(counter == n ){
                    //normal move
                    fast=fast.next;
                    prev=slow;
                    slow=slow.next;
                }else{
                    //one pointer move
                    fast=fast.next;
                    counter++;
                }
            }
            return head;
        }
}
