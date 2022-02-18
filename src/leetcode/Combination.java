package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 문제 : https://leetcode.com/problems/combinations/
 *  레벨 : Medium
 *  결과 : 해결(runtime 229ms faster than 5.03%, memory 206.4MB less than 5.01%)
 * */

public class Combination {

    public static List<List<Integer>> combine(int n, int k) {

        Queue<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 1; i <= n-k+1; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(i);
            queue.add(al);
        }

        while (!queue.isEmpty()) {

            List<Integer> poll = queue.poll();
            int last = poll.get(poll.size() - 1);
            if(poll.size() == k){
                answer.add(poll);
                continue;
            }

            for(int i = last + 1; i <= n; i++){
                List<Integer> input = new ArrayList<>(poll);
                input.add(i);
                queue.add(input);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        System.out.println(combine(n, k));

    }
}
