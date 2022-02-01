package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q12852 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer>[] al; // al을 배열로 선언해서 N을 1로 만드는 숫자들을 차례로 저장
        int[] arr; // i 숫자별 최소값을 저장
        /* n이 3 이하일때 초기화(밑에서 al[2]와 al[3]에 값을 셋팅해서 ArrayIndexOutOfBounds 에러 발생 */
        if (n <= 3) {
            al = new ArrayList[4];
            arr = new int[4];
        } else {
            al = new ArrayList[n + 1];
            arr = new int[n + 1];
        }

        for (int i = 0; i <= n; i++) {
            al[i] = new ArrayList<>();
        }
        al[1] = new ArrayList<>();
        al[1].add(1);

        al[2] = new ArrayList<>();
        al[2].add(1);
        al[2].add(2);

        al[3] = new ArrayList<>();
        al[3].add(1);
        al[3].add(3);

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            if (i % 3 == 0) { //3으로 나눠지면, arr[i/3] + 1을 하면 최소값으로 설정 가능
                if (min > 1 + arr[i / 3]) {
                    min = 1 + arr[i / 3];
                    minIdx = 3;
                }
            }
            if (i % 2 == 0) { //2으로 나눠지면, arr[i/2] + 1을 하면 최소값으로 설정 가능
                if (min > 1 + arr[i / 2]) {
                    min = 1 + arr[i / 2];
                    minIdx = 2;
                }
            }
            if (min > 1 + arr[i - 1]) { //arr[i-1] + 1 이 가장 최소값이면 최소값으로 설정 가능
                min = 1 + arr[i - 1];
                minIdx = 1;
            }
            // al[minIdx]의 값을 al[i] 에 값 복사
            if (minIdx == 3) {
                for (int j : al[i / 3]) {
                    al[i].add(j);
                }
            } else if (minIdx == 2) {
                for (int j : al[i / 2]) {
                    al[i].add(j);
                }
            } else if (minIdx == 1) {
                for (int j : al[i - 1]) {
                    al[i].add(j);
                }
            }
            al[i].add(i);
            arr[i] = min;
        }
        System.out.println((al[n].size() - 1));
        StringBuilder sb = new StringBuilder();
        for (int i = al[n].size() - 1; i >= 0; i--) {
            sb.append(al[n].get(i) + " ");
        }
        System.out.println(sb);
    }
}
