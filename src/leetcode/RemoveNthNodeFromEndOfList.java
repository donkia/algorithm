package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/longest-consecutive-sequence/
 * 레벨 : Medium
 * 결과 : 해결(runtime 2ms faster than 5.93%, memory 42.7MB less than 25.12%)
 */

public class RemoveNthNodeFromEndOfList {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int cnt = 0;
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode indexNode = head;

        //전체 노드의 개수 구하기 && arraylist에 모든 LitNode 넣기
        while(indexNode.next != null){
            listNodeList.add(indexNode);
            indexNode = indexNode.next;
        }

        listNodeList.add(indexNode);
        cnt = listNodeList.size();

        // arrayList의 값들을 확인하며 뒤에서 n번째인 listNode 제거
        List<ListNode> newListNode = new ArrayList<>();
        listNodeList.remove(cnt - n);

        // 뒤에서 n번째를 제거하고 arrayList값들 연결하기
        if(listNodeList.isEmpty()){
            return null;
        }
        
        ListNode firstNode = new ListNode(listNodeList.get(0).val);
        newListNode.add(firstNode);


        for(int i = 1; i < listNodeList.size(); i++){
            ListNode next = new ListNode(listNodeList.get(i).val);

            newListNode.get(i - 1).next = next;
            newListNode.add(next);

        }
        return newListNode.get(0);
    }

    public static void main(String[] args) {
        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        ListNode temp3 = new ListNode(3);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);
        int n = 5;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;


        System.out.println(removeNthFromEnd(temp1, n));



    }
}
