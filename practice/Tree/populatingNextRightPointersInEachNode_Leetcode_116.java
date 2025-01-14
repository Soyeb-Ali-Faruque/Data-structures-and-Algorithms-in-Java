package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class populatingNextRightPointersInEachNode_Leetcode_116 {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int _val) {
            val = _val;
        }

        Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public void connecting(Node node) {
        //base condition to prevent reading left and right poinetr of leaf node
        if(node.left == null) return;
        //connect nodes childrens
        node.left.next=node.right;
        if(node.next != null) node.right.next = node.next.left;
        connecting(node.left);
        connecting(node.right);
    }



}
