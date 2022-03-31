package leetcode;

import java.math.BigInteger;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/add-two-numbers/
 * 레벨 : Medium
 * 결과 : 해결(runtime 8ms faster than 5.96%, memory 42.6MB less than 81.61%)
 */

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //l1 요소들의 합
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        //l2 요소들의 합
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        // reverse 하기
        sb1.reverse();
        sb2.reverse();
        // 덧셈(숫자가 클 수 있으니 BigInter로 구현)
        BigInteger bigInteger_sb1 = new BigInteger(sb1.toString());
        BigInteger bigInteger_sb2 = new BigInteger(sb2.toString());
        BigInteger sum = bigInteger_sb1.add(bigInteger_sb2);
        
        StringBuilder strSum = new StringBuilder(sum.toString()).reverse();
        // 구해진 합계로 ListNode 만든 후 return하기
        ListNode answer = null;
        ListNode index = null;
        for (int i = 0; i < strSum.length(); i++) {
            if (i == 0) {
                answer = new ListNode(Integer.parseInt(strSum.substring(i, i + 1)));
            } else if (i == 1) {
                index = new ListNode(Integer.parseInt(strSum.substring(i, i + 1)));
                answer.next = index;
            } else {
                ListNode temp = new ListNode(Integer.parseInt(strSum.substring(i, i + 1)));
                index.next = temp;
                index = index.next;
            }


        }
        return answer;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);

        l1.next = l1_1;
        l1_1.next = l1_2;


        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);

        l2.next = l2_1;
        l2_1.next = l2_2;

        System.out.println(addTwoNumbers(l1, l2));

    }
}
