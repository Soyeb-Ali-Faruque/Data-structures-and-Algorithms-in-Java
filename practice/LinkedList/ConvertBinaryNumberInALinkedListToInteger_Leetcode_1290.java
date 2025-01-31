package LinkedList;

public class ConvertBinaryNumberInALinkedListToInteger_Leetcode_1290 {
    public static void main(String[] args) {
        System.out.println(1<<3);
    }
    static int c=1;
    public int getDecimalValue(ListNode head) {
        int ans=helper(head);
        c=1;
        return ans;

    }
    private static int helper(ListNode node){
        if(node.next == null) return 1;
        return helper(node.next)|(node.val<<c++);
    }
}
