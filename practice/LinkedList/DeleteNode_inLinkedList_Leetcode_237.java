package LinkedList;

public class DeleteNode_inLinkedList_Leetcode_237 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
