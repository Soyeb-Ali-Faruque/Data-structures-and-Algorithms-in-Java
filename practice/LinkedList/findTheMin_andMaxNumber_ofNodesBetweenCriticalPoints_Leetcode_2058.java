package LinkedList;

public class findTheMin_andMaxNumber_ofNodesBetweenCriticalPoints_Leetcode_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) return new int[]{-1,-1};
        int[] ans={Integer.MAX_VALUE,Integer.MIN_VALUE};
        //critical points marker
        boolean firstCriticalPoint=false;
        boolean secondCriticalPoint=false;

        //pointers
        ListNode prev=head;
        ListNode current=head.next;
        ListNode next=current.next;

        //breakpoints
        int breakpoint1=-1;
        int breakpoint2=-1;

        //counter
        int counter=0;

        while(next!=null){
            counter++;
            if(islocalMaxima(prev) || islocalMinima(prev)){
                if(!firstCriticalPoint) {
                    firstCriticalPoint=true;
                    breakpoint2=counter;
                    breakpoint1=counter;
                }
                else{
                    secondCriticalPoint=true;
                    int d1=(counter - breakpoint1); //renoting min distance between 2 C_point
                    //updating breakpoint
                    breakpoint1=counter;
                    if(d1<ans[0]) ans[0] = d1;

                    int d2=(counter - breakpoint2);
                    ans[1]=d2;
                }
            }
            prev=current;
            current=next;
            next=next.next;
        }
        if(!secondCriticalPoint) return new int[]{-1,-1};
        return ans;

    }
    private boolean islocalMinima(ListNode node){
        return ((node.val>node.next.val)&& (node.next.val <node.next.next.val));
    }
    private boolean islocalMaxima(ListNode node){
        return ((node.val<node.next.val) &&( node.next.val > node.next.next.val));

    }
}
