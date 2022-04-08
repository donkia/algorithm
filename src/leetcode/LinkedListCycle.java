package leetcode;
import java.util.ArrayList;


/**
 * 문제 : https://leetcode.com/problems/linked-list-cycle/
 * 레벨 : Easy
 * 결과 : 참고 후 해결(runtime 196ms faster than 6.56%, memory 46.1MB less than 35.95%)
 */

public class LinkedListCycle {

    static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {


        ListNode node = head;
        ArrayList<ListNode> arrayList = new ArrayList<>();


        while(node != null){

            arrayList.add(node);
            node = node.next;

            for(int i = 0; i < arrayList.size(); i++){
                if(arrayList.get(i) == node){
                    return true;
                }
            }

        }

        return false;
    }
}
