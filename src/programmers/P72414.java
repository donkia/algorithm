package programmers;
/** 프로그래머스 광고삽입(level 3)
 * https://programmers.co.kr/learn/courses/30/lessons/72414
 * 문제 해결 상태 : △(다른사람 풀이보고 pass) (+4점 획득)
 * */
public class P72414 {

    // 문자열 s(HH:MM:SS)를 초 단위로 변경하는 메서드
    public static int convertToSecond(String s) {
        String[] log = s.split(":");
        return Integer.parseInt(log[0]) * 3600 + Integer.parseInt(log[1]) * 60 + Integer.parseInt(log[2]);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        // 모든 시간들을 초로 변환해서 저장하는 배열(time) 선언
        int[] time = new int[convertToSecond(play_time) + 1];
        int nAdv_time = convertToSecond(adv_time);
        int playTime = convertToSecond(play_time);

        // 배열에 초(second) 대입
        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split("-");

            int startTime = convertToSecond(log[0]);
            int endTime = convertToSecond(log[1]);

            for (int j = startTime; j < endTime; j++) {
                time[j]++;
            }
        }
        int maxidx = 0;
        long sum = 0;
        int endTime = nAdv_time;
        int startTime = 0;
        // 00초 부터 광고인 시간까지 합 구하기
        for(int i =startTime; i < endTime; i++){
            sum = sum + time[i];
        }
        // 누적값을 구하면서 각 초마다 광고를 넣을 때 최대값을 찾기
        long max = sum;
        while(endTime <= playTime){
            sum = sum - time[startTime];
            sum = sum + time[endTime];
            if(sum > max){
                max = sum;
                maxidx = startTime + 1;
            }
            startTime = startTime + 1;
            endTime = endTime + 1;
        }
        // 가장 max인 maxidx를 hh:mm:ss로 변환 후 return
        String hour = "";
        if (maxidx / 3600 < 10) {
            hour = "0" + Integer.toString(maxidx / 3600);
        } else
            hour = Integer.toString(maxidx / 3600);

        maxidx = maxidx % 3600;
        String minute = "";
        if (maxidx / 60 < 10) {
            minute = "0" + Integer.toString(maxidx / 60);
        } else {
            minute = Integer.toString(maxidx / 60);
        }
        maxidx = maxidx % 60;

        String second = Integer.toString(maxidx);
        if (maxidx < 10) {
            second = "0" + Integer.toString(maxidx);
        }

        return hour + ":" + minute + ":" + second;
    }


    public static void main(String[] args) {
       /*
       String play_time = "02:03:55";
        String adv_time = "00:14:15";

       String[] logs = {
                "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:01-01:53:29", "01:37:44-02:02:30"
        };*/
       /*
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
       String[] logs = {
                "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
        };*/
        String play_time = "50:00:00";
        String adv_time = "50:00:00";

        String[] logs = {
                "15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"
        };

        System.out.println(solution(play_time, adv_time, logs));

    }
}
