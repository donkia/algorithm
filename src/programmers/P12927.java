package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P12927 {
    public static long solution(int n, int[] works) {
        long answer = 0;

        // 내림차순으로 priorityQueue 생성
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < works.length; i ++){
            priorityQueue.add(works[i]);
        }

        for(int i = 0; i < n; i++){
            if(priorityQueue.isEmpty()) break; //큐가 비었을때, nullpoint Exception 발생으로 예외처리

            int poll = priorityQueue.poll();
            poll = poll - 1;
            if(poll > 0){
                priorityQueue.add(poll);
            }
        }

        while(!priorityQueue.isEmpty()){
            int poll = priorityQueue.poll();
            answer += poll * poll;
        }

        return answer;
    }



    public static void main(String[] args) {

        int[] works = {1, 1};
        int n = 3;

        System.out.println(solution(n, works));
    }

}
