package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_Leetcode_234 {
    public boolean isPalindrome(ListNode head) {

    }
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
