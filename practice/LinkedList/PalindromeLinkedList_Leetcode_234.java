package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_Leetcode_234 {
    //Time 0(n) and Space 0(1)
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode mid=moveHead(head);
        ListNode tail=reverse(mid);
        return compare(head,tail);

    }
    private ListNode moveHead(ListNode head){
        int size=getSize(head)/2;
        for(int i=1;i<=size;i++){
            head=head.next;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        ListNode next=head.next;
        while(current != null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!= null) next=next.next;
        }
        return prev;
    }
    private boolean compare(ListNode head,ListNode tail){
            while(true){
                if(head.val != tail.val) return false;
                if(head == tail || head.next == tail) break;
                head=head.next;
                tail=tail.next;
            }
            return true;
    }


    private int getSize(ListNode head){
        int size=0;
        while(head!=null){
            size++;
            head=head.next;
        }return size;
    }


    //Time 0(n) and Space 0(n)
    static boolean bruteForce_helper(ListNode node){
        //stack
        Stack<Integer> storage=new Stack<>();
        ListNode temp=node;
        while(temp != null){
            storage.push(temp.val);
            temp=temp.next;
        }
        for(int i=0;i<storage.size()/2;i++){
            if(node.val != storage.pop()) return false;
        }
        return true;
    }

}
