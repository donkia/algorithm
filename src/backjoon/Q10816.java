package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q10816 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input값 셋팅
        int n = Integer.parseInt((String) sc.nextLine());
        int[] sanggeonCard = new int[n];

        // 숫자카드의 범위가 -10000000 ~ 100000000 이이서
        // 양수, 음수를 저장할 수 있는 배열 선언
        int[] plus = new int[10000001];
        int[] minus = new int[10000001];

        String temp = sc.nextLine();
        String[] split = temp.split(" ");
        for (int i = 0; i < n; i++) {
            sanggeonCard[i] = Integer.parseInt(split[i]);

            //양수면 plus 배열에 카운트
            if(sanggeonCard[i] >= 0)
                plus[sanggeonCard[i]]++;
            else
                //음수면 minus 배열에 카운트
                minus[(sanggeonCard[i]*-1)] ++;
        }

        int m = Integer.parseInt((String) sc.nextLine());
        int[] card = new int[m];

        temp = sc.nextLine();
        split = temp.split(" ");
        for (int i = 0; i < m; i++) {
            card[i] = Integer.parseInt(split[i]);
        }

        //Arrays.sort(sanggeonCard);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < card.length; i++){
            int cnt = 0;
            //양수면 plus 배열에서, 음수면 minus 배열에서 cnt조회
            if(card[i] >= 0)
                cnt = plus[card[i]];
            else
                cnt = minus[(card[i] * -1)];

            sb.append(cnt + " ");
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] arr, int answer) {

        int first = 0;
        int last = arr.length-1;
        int cnt = 0;

        while(first <= last){

            int mid = (first + last) / 2;

            if(answer < arr[mid]){
                last = mid - 1;
            } else if (answer > arr[mid]) {
                first = mid + 1;
            }
            else {
                for(int i = first ; i <= last ; i++){
                    if(arr[i] == answer)
                        cnt++;
                }
                return cnt;
            }

        }


        return cnt;
    }
}


