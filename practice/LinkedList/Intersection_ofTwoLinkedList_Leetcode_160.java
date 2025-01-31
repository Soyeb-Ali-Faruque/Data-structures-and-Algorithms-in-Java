package LinkedList;

public class Intersection_ofTwoLinkedList_Leetcode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getSize(headA);
        int b=getSize(headB);
        int diff=Math.abs(a-b);
        ListNode nodeA=headA;
        ListNode nodeB=headB;
        //check which one is bigger
        if(a>b){
            for(int i=0;i<diff;i++){
                nodeA=nodeA.next;
            }

        }else{
            for(int i=0;i<diff;i++){
                nodeB=nodeB.next;
            }

        }
        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB) return nodeA;
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return null;


    }
    private int getSize(ListNode head){
        int size=0;
        while(head!=null){
            size++;
            head=head.next;
        }return size;
    }
}
