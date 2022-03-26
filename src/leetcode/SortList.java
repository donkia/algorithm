package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/sort-list/
 * 레벨 : Medium
 * 결과 : 해결(runtime 10ms faster than 54.34%, memory 50MB less than 91.34%)
 */

public class SortList {

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


    public static ListNode sortList(ListNode head) {
        
        // 파라미터에 빈값이 넘어올 때
        if(head.next == null){
            return new ListNode();
        }
        
        // List에 넣은 후 sort 예정
        List<ListNode> listNodes = new ArrayList<>();
        ListNode listNode = head;
        while(listNode.next != null){
            ListNode newLode = new ListNode(listNode.val);
            listNodes.add(newLode);
            listNode = listNode.next;
        }
        ListNode newLode = new ListNode(listNode.val);
        listNodes.add(newLode);

        // ListNode.val 의 값에 따라 정렬
        Collections.sort(listNodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 정렬된 ListNode 클래스에 대해 순차적으로 연관관계 설정
        for(int i = 0; i < listNodes.size()-1; i++){
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return listNodes.get(0);


    }

    public static void main(String[] args) {

      /*  ListNode listNode4 = new ListNode(3);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(4, listNode2);*/

        ListNode listNode4 = new ListNode(-1);
        ListNode listNode3 = new ListNode(5, listNode4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(4, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);


        System.out.println(sortList(listNode0));

    }
}
