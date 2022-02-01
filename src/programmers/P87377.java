package programmers;

import java.util.ArrayList;

public class P87377 {

    static final long MAX = Long.MAX_VALUE;
    /**
     * 교점을 구하기 위한 함수
     * 교점이 없으면 Long.MAX_VALUE로 return
     */
    public static long[] calculateLocation(long a, long b, long e, long c, long d, long f){
        if((a*d - b*c) == 0){
            return new long[]{MAX, MAX};
        }
        else if((b*f - e*d) % (a*d - b*c) == 0){
            if((e*c- a*f) % (a*d - b*c) == 0){
                long x = (b * f - e * d) / (a * d - b * c);
                long y = (e * c - a * f) / (a * d - b * c);
                return new long[]{x, y};
            }
        }
        return new long[]{MAX, MAX};
    }
    public static String[] solution(int[][] line) {
        ArrayList<long[]> contactPoint = new ArrayList<>();
        /** 교점을 구하고 contactPoint에 교점 좌표를 넣음 */
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++){
                //29번 테스트케이스가 오류나서 int형 -> long형으로 변경
                long[] point = calculateLocation(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(point[0] != MAX && point[1] != MAX) {
                    contactPoint.add(point);
                }
            }
        }
        // 교점 좌표 중 x,y 좌표의 max값과 min값을 찾음
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        for(int i = 0; i < contactPoint.size(); i++){
            long[] temp = contactPoint.get(i);
            long tempX = temp[0];
            long tempY = temp[1];
            if(tempX > maxX){
                maxX = tempX;
            }
            if(tempX < minX){
                minX = tempX;
            }
            if(tempY > maxY){
                maxY = tempY;
            }
            if(tempY < minY){
                minY = tempY;
            }
        }
        // * 또는 . 을 출력
        StringBuilder sb = new StringBuilder();
        for(long i = maxY; i >= minY; i--){
            for(long j = minX; j <= maxX; j++){

                long[] temp = new long[]{j, i};
                boolean isSame = false;
                for(long[] point : contactPoint){
                    if(point[0] == temp[0] && point[1] == temp[1]){
                        isSame = true;
                        sb.append("*");
                        break;
                    }
                }
                if(isSame == false)
                    sb.append(".");
            }
            sb.append("\n");
        }
        String[] answer = sb.toString().split("\n");
        return answer;
    }


    public static void main(String[] args) {
/*

        int[][] line = {
                {2, -1, 4}, //2x -y + 4 = 0
                {-2, -1, 4}, // -2x -y + 4 = 0
                {0, -1, 1}, // -y + 1 = 0
                {5, -8, -12},
                {5, 8, 12}
        };
*/

        int[][] line = {
                {-1, -1, -1},
                {1, 1, 1},
        };
        System.out.println(solution(line));

    }
}
