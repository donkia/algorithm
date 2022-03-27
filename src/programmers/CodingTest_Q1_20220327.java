package programmers;

// 100점
public class CodingTest_Q1_20220327 {

    public static int solution(int speed_limit, int[][] cameras) {
        int answer = 0;

        int startLocation = 0; //시작위치
        int endLocation = 0; //끝 위치
        int hour = 0; // 걸린시간

        for (int i = 0; i < cameras.length; i++) {

            endLocation = cameras[i][0];
            hour = cameras[i][1] - hour;


            int speed = (endLocation - startLocation) / hour;
            if((endLocation - startLocation) % hour != 0){ // 예제처럼 hour로 나눠떨어지지않는 경우
                speed ++;
            }

            if (speed > speed_limit) {
                answer++;
            }
            startLocation = endLocation;
            hour = cameras[i][1];
        }


        return answer;
    }


    public static void main(String[] args) {
        /*int speed_limit = 60;
        int[][] cameras = {
                {60, 1},{130, 2},{240, 4},{432, 7},
        };
        */
        int speed_limit = 30;
        int[][] cameras = {
                {60, 3},{152, 6},{240, 9}
        };

        System.out.println(solution(speed_limit, cameras));

    }
}
