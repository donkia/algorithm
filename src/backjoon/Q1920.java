package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input값 셋팅
        int n = Integer.parseInt((String) sc.nextLine());
        int[] arr = new int[n];

        String temp = sc.nextLine();
        String[] split = temp.split(" ");
        for(int i = 0; i < n ; i ++){
            arr[i] = Integer.parseInt(split[i]);
        }
        //int[] arr = new int[]{4, 1, 5, 2, 3}; // 1 2 3 4 5

        int m = Integer.parseInt((String) sc.nextLine());
        int[] brr = new int[m];

        temp = sc.nextLine();
        split = temp.split(" ");
        for(int i = 0; i < m ; i ++){
            brr[i] = Integer.parseInt(split[i]);
        }

        // arr 정렬
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        // 이중 for문을 통한 숫자 찾기
        /*for(int i = 0 ; i < brr.length; i++){
            int cnt = 0;
            for(int j = 0 ; j < arr.length; j++){

                if(brr[i] == arr[j]){
                    sb.append("1");
                    cnt ++ ;
                    break;
                }
                else if(brr[i] < arr[j]){
                    sb.append("0");
                    cnt ++;
                    break;
                }
            }
            if(cnt == 0)
                sb.append("0");

            sb.append('\n');
        }
*/

        for(int i = 0; i < brr.length; i++){
            //int answer = binarySearch(arr, brr[i]);
            int answer = Arrays.binarySearch(arr, brr[i]);
            //System.out.println(answer);
            if(answer >= 0){
                sb.append("1");
            }
            else
                sb.append("0");
            sb.append('\n');
        }
        //결과값 출력
        System.out.println(sb);
    }

    static int binarySearch(int[] arr, int answer){

        int first = 0;
        int last = arr.length - 1;

        while(first <= last){

            int mid = (first+last) / 2;

            if(arr[mid] < answer){
                first = mid + 1;
            }
            else if(arr[mid] > answer){
                last = mid - 1;
            }
            else
                return mid;
        }
        return -1;
    }
}
