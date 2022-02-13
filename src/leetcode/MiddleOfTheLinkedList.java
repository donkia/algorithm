package leetcode;

/** 문제 : https://leetcode.com/problems/middle-of-the-linked-list/
 *  레벨 : Easy
 *  결과 : 풀이 참고 후 해결(runtime 0ms faster than 100.00%, memory 41.7MB less than 8.66%)
 * */


public class MiddleOfTheLinkedList {

    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }



    public static ListNode middleNode(ListNode head) {

        ListNode oneStep = head; //노드 하나는 한칸씩
        ListNode twoStep = head; //다른노드는 두칸씩 이동

        while(twoStep != null && twoStep.next != null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }

        // 두칸씩 이동하는 노드가 더이상 이동안하면 끝부분에 도착
        return oneStep;

    }

    public static void main(String[] args) {

    }

}
