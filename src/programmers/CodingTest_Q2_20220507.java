package programmers;

import java.util.ArrayList;
import java.util.Collections;

// 100점

public class CodingTest_Q2_20220507 {

    static int min;
/*
    public static void DFS(ArrayList<Integer> teams, int idx, int[] stats) {

        if (idx == stats.length) {
            min = Math.min(min, teams.size());
            return;
        }

        for (int i = idx; i < stats.length; i++) {
            int grade = stats[i];

            //가장 작을 때 -> 새로운 팀을 만듬
            if (grade < teams.get(0)) {
                ArrayList<Integer> tempTeam = new ArrayList<>(teams);
                tempTeam.add(0, grade);
                DFS(tempTeam, idx + 1, stats);
            }
            // 새로운 팀을 만들지 않고, 기존팀에 투입 될 때
            else {
                for (int j = 0; j < teams.size(); j++) {
                    if (grade > teams.get(j)) {
                        ArrayList<Integer> tempTeam = new ArrayList<>(teams);
                        tempTeam.set(j, grade);
                        DFS(tempTeam, idx + 1, stats);
                    }
                }
            }
        }
    }
*/
    public static int solution(int[] stats) {
        ArrayList<Integer> teams = new ArrayList<>();

        // 첫번째 사람은 새로운 팀을 만들어야함
        teams.add(stats[0]);


        for (int i = 1; i < stats.length; i++) {
            int grade = stats[i];

            Collections.sort(teams);

            //가장 클 때 -> 마지막 팀에 들어감
            if (grade > teams.get(teams.size() - 1)) {
                teams.set(teams.size() - 1, grade);
            }
            //가장 작을 때 -> 새로운 팀을 만듬
            else if (grade < teams.get(0)) {
                teams.add(0, grade);
            }
            //중간정도 일때 -> 첫번째 팀에 들어감
            else {
                //teams.set(0, grade);
                for(int j = 0; j < teams.size(); j++) {
                    if (grade < teams.get(j)) {
                        teams.set(j - 1, grade);
                        break;
                    }
                }
            }
        }
        return teams.size();
       
    }

    public static void main(String[] args) {
        int[] stats = {5, 3, 4, 6, 2, 1};
        System.out.println(solution(stats));

        stats = new int[]{6, 2, 3, 4, 1, 5};
        System.out.println(solution(stats));

        stats = new int[]{13, 3, 6, 2, 8, 12, 5};
        System.out.println(solution(stats));


    }

}
// 두번째 사람부터 순차적으로 확인
       /* 
       O(n) -> 다 틀림
       
       for (int i = 1; i < stats.length; i++) {
            int grade = stats[i];

            Collections.sort(teams);

            //가장 클 때 -> 마지막 팀에 들어감
            if (grade > teams.get(teams.size() - 1)) {
                teams.set(teams.size() - 1, grade);
            }
            //가장 작을 때 -> 새로운 팀을 만듬
            else if (grade < teams.get(0)) {
                teams.add(0, grade);
            }
            //중간정도 일때 -> 첫번째 팀에 들어감
            else {
                teams.set(0, grade);
            }
        }
        return teams.size();
        */

 /*
        DFS -> 전부 다 시간초과
 min = Integer.MAX_VALUE;
         // 팀을 저장하는 ArrayList 선언
         ArrayList<Integer> teams = new ArrayList<>();

        // 첫번째 사람은 새로운 팀을 만들어야함
        teams.add(stats[0]);
        DFS(teams, 1, stats);
        return min;*/