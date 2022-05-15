package homework;

public class kakaopaysec_Q2_20220515 {

    // R : 오른쪽 회전
    public static int[][] rotateR(int[][] map) {
        int[][] rotateMap = new int[map[0].length][map.length];

        int k = 0;
        for (int i = map.length - 1; i >= 0; i--) {
            int[] arr = map[i];
            for (int j = 0; j < arr.length; j++) {
                rotateMap[j][k] = arr[j];
            }
            k = k + 1;
        }
        return rotateMap;
    }

    // L : 왼쪽 회전
    public static int[][] rotateL(int[][] map) {
        int[][] rotateMap = new int[map[0].length][map.length];

        int k = 0;
        for (int i = 0; i < map.length; i++) {
            int[] arr = map[i];
            for (int j = arr.length - 1; j >= 0; j--) {
                rotateMap[j][k] = arr[arr.length - 1 - j];
            }
            k = k + 1;
        }
        return rotateMap;
    }

    // T : 뒤집기
    public static int[][] rotateT(int[][] map) {
        int[][] rotateMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                rotateMap[i][j] = map[i][map[0].length - 1 - j];
            }
        }
        return rotateMap;
    }


    public static int solution(int row, int col, String locations, String input, String print) {

        int[][] map = new int[row][col];
        String[] split = input.split(",");

        // 배열 생성
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(split[cnt++]);
            }
        }

        // 회전할 신규 배열 생성
        int[][] rotateMap = map;
        // 회전 명령어에 따른 배열 회전
        for (int i = 0; i < locations.length(); i++) {
            String location = locations.substring(i, i + 1);

            if (location.equals("R")) {
                rotateMap = rotateR(rotateMap);
            } else if (location.equals("L")) {
                rotateMap = rotateL(rotateMap);
            } else if (location.equals("T")) {
                rotateMap = rotateT(rotateMap);
            }
        }
        //배열 위치 출력
        String[] printArr = print.split(",");
        return rotateMap[Integer.parseInt(printArr[1]) - 1][Integer.parseInt(printArr[0]) - 1];

    }


    public static void main(String[] args) {
        /* 입력값 */
        int row = 3;    //가로열
        int col = 3;    //세로열
        String input = "1,2,3,4,5,6,7,8,9";     //배열 데이터
        String locations = "RRT";   // 회전 명령어
        String print = "1,3"; //출력할 배열위치
        System.out.println(solution(row, col, locations, input, print)); //최종 출력 데이터
    }
}
