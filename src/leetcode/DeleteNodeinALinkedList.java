package leetcode;

/**
 * 문제 : https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 레벨 : Easy
 * 결과 : 해결(runtime 0ms faster than 100.00%, memory 41.5MB less than 94.14%)
 */

class ListNode{

    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

public class DeleteNodeinALinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }


    public static void main(String[] args) {

    }
}
