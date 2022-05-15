package homework;

import java.util.ArrayList;

public class kakaopaysec_Q3_20220515 {

    public static int solution(int people, int distance, ArrayList<Integer> list){

        int distanceCnt = 0;    //이동할 거리 구하기
        int idx = 0;    //ArrayList를 순회하기 위한 인덱스 변수 선언
        int failCnt = 0;    //탈락한 사람 갯수 구하기

        //마지막으로 남은 사람이 구해질때 까지 반복함
        while(failCnt != people-1){

            if(idx >= people){
                idx = idx % people; //인덱스가 사람의 숫자보다 넘을 때 0부터 다시 시작하게 변경
            }

            if(list.get(idx) != 0){
                distanceCnt = distanceCnt + 1;
            }

            if(distanceCnt == distance){
                list.set(idx, 0);    //탈락한 사람 인덱스는 0으로 변경
                distanceCnt = 0;
                failCnt++;          //탈락한 사람 count
            }
            idx = idx + 1;
        }
        //마지막으로 남은사람 구하기
        int passPerson = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != 0) {
                passPerson = list.get(i);
            }
        }
        return passPerson;
    }


    public static void main(String[] args) {
        int people = 5; //사람 수
        int distance = 2;   //이동할 거리

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= people; i++){
            list.add(i);
        }
        System.out.println(solution(people, distance, list));
    }
}
