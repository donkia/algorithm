package programmers;

public class P68936 {
    static int cntZero = 0;
    static int cntOne = 0;

    // 4면이 모두 같은 숫자인지 확인하는 함수
    public static boolean isSame(int[][]arr, int n, int x, int y){

        int sum = 0;
        for(int i = x; i < n + x; i++){

            for(int j = y; j < n + y; j++){
                sum += arr[i][j];
            }
        }
        //모두 0 일때
        if(sum == 0){
            return true;
        }
        else if(sum == n * n){ // 모두 1일 때
            return true;
        }
        else
            return false;
    }
    // 분할탐색을 하는 함수
   public static void divide(int[][] arr, int n, int x, int y){
        //4면이 모두 같을때 모두 0인지, 모두 1인지 판단
        if(isSame(arr, n, x, y)){
            if(arr[x][y] == 0){
                cntZero++;
            }
            else {
                cntOne++;
            }
        }
        // 4면이 모두 다를때 4등분해서 다시 탐색
        else{
            divide(arr, n/2, x, y);
            divide(arr, n/2, x, y+n/2);
            divide(arr, n/2, x+n/2, y);
            divide(arr, n/2, x+n/2, y+n/2);
        }
    }


    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        // 분할탐색을 시작함
        divide(arr, arr.length, 0, 0);
        answer[0] = cntZero;
        answer[1] = cntOne;

        return answer;
    }


    public static void main(String[] args) {

        int[][] arr ={
                {1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}
        };

        System.out.println(solution(arr));

    }

}
