package programmers;

import java.util.ArrayList;
public class P92342 {
    static int max = 0;
    static ArrayList<Integer> al = new ArrayList<>();

    public static void DFS(int[] info, int n, int[] lion, int idx) {
        int sum = 0;
        // lion의 모든 원소의 합을 구함
        for (int i = 0; i < lion.length; i++) {
            sum += lion[i];
        }
        if(idx > lion.length){
            return ;
        }
        // lion의 모든 원소의 합이 n이랑 같을 때
        if (sum == n) {
            int sumApeach = 0;
            int sumLion = 0;
            for (int i = 0; i < info.length; i++) {

                if (info[i] < lion[i]) {
                    sumLion += 10 - i;
                } else if (lion[i] == 0 && info[i] == 0) {
                    continue;
                } else {
                    sumApeach += 10 - i;
                }
            }
            // lion 점수와 apeach 점수 차이 비교
            if (max <= sumLion - sumApeach) {
                if(max < sumLion-sumApeach){
                    max = sumLion - sumApeach;
                    al.clear();
                    for(Integer l : lion){
                        al.add(l);
                    }
                }
                // 점수 차이가 max값이랑 같을 때 점수 비교
                else if(max == sumLion - sumApeach){
                    boolean isChange = false;
                    for(int i = 10; i>=0; i--){
                        if(al.get(i) != lion[i]){
                            if(al.get(i) > lion[i])
                                isChange = false;
                            else
                                isChange = true;
                            break;
                        }
                    }
                    if(isChange == true){
                        al.clear();
                        for(Integer l : lion){
                            al.add(l);
                        }
                    }
                }
            }
            return;
        }
        // 마지막 index에 도달하면 n-sum값 대입
        if (idx == lion.length-1) {
            if (sum < n) {
                lion[idx] = n - sum;
                DFS(info, n, lion, idx + 1);
            }
        } else {
            int[] temp = new int[11];
            for(int j = 0; j < 11; j++){
                temp[j] = lion[j];
            }
            // line[index]에 0 으로 대입
            DFS(info, n, lion, idx + 1);
            // line[index]에 info[idx] + 1 값 대입
            if (info[idx] + 1 + sum <= n) {
                temp[idx] = info[idx] + 1;
                DFS(info, n, temp, idx + 1);
            }
        }
    }
    public static int[] solution(int n, int[] info) {

        int[] answer = new int[11];
        int[] lion = new int[info.length];

        for(int i = 0; i < lion.length; i++){
            al.add(lion[i]);
        }
        // DFS 바탕으로 모든 경우의 수 찾기
        DFS(info, n, lion, 0);
        // 일치하는게 없으면 -1 리턴
        if(max == 0) {
            return new int[]{-1};
        }
        else {
            int idx = 0;
            for(Integer l : al){
                answer[idx] = l;
                idx ++;
            }
            return answer;
        }

    }

    public static void main(String[] args) {

       /* int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
*/

        int n = 10;
        int[] info = {0, 0,0 , 0, 0, 0, 0, 0, 3, 4, 3};
/*
        int n = 9;
        int[] info = {0, 0,1 , 2, 0, 1, 1, 1, 1, 1, 1};
        */
/*
        int n = 1;
        int[] info = {1, 0,0 , 0, 0, 0, 0, 0, 0, 0, 0};
*/

        System.out.println(solution(n, info));

    }
}
