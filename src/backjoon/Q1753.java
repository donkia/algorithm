package backjoon;

import java.util.*;

class Node implements Comparable<Node>{
    public int y;
    public int w;

    public Node(int y, int w) {
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Q1753 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input값 셋팅
        String[] temp = sc.nextLine().split(" ");
        int v = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(sc.nextLine());

        ArrayList<Node>[] al = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            temp = sc.nextLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);

            al[x].add(new Node(y, w));
        }

        // 필요한 변수들 선언
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int[] distance = new int[v + 1];
        boolean[] vis = new boolean[v + 1];

        // 시작점인 k 부터 시작
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        priorityQueue.offer(new Node(k, 0));

        while(!priorityQueue.isEmpty()){
            int current = priorityQueue.poll().y;
            if(vis[current]) continue;
            vis[current] = true;

            for(Node next : al[current]){

                if(distance[next.y] > distance[current]+ next.w) {
                    distance[next.y] = next.w + distance[current];
                    priorityQueue.offer(new Node(next.y, distance[next.y]));
                }
            }
        }
/*      잘못된 풀이. priorityqueue를 안쓰고 그냥 queue를 씀
        while (!queue.isEmpty()) {

            backjoon.Node poll = queue.poll();
            int y = poll.y;
            int sum = poll.w;

            if(visit[y] < sum)
                continue;

            for (int i = 0; i < al[y].size(); i++) {
                    int m = al[y].get(i).y;
                    visit[m] = Math.min(visit[m], sum + al[y].get(i).w);
                    queue.add(new backjoon.Node(m, sum + al[y].get(i).w));
            }
        }
*/
        // 결과값 print
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF");
            else
                sb.append(distance[i]);
            sb.append('\n');
        }

        System.out.println(sb);
    }


}
