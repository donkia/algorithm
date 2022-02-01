package programmers;

public class P92335 {
    public static int solution(int n, int k) {
        int answer = 0;
        // k진수로 변경
        StringBuilder prime = new StringBuilder();
        while(n > k){
            int mod = n % k;
            n = n / k;
            prime.append(mod);
        }
        prime.append(n);
        prime.reverse();
        // 0으로 짜르기
        String[] primeArr = prime.toString().split("0");

        // 소수인지 확인
        for(int i = 0; i < primeArr.length; i++){
            if(primeArr[i].equals("")){
                continue;
            }
            long num = Long.parseLong(primeArr[i]); // 런타임 에러났던 부분. int를 Long으로 변경하니 해결

            boolean isPrime = true;
            if(num == 1){
                isPrime = false;
            }
            else if(num == 2 || num == 3 || num == 5 || num == 7){
            }
            else {
                for (int j = 2; j < Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if(isPrime == true){
                answer = answer + 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 11;
        int k = 10;
        System.out.println(solution(n, k));
/*

        for(int i = 1; i<= 1000000;i ++){
            for(int j = 3; j <= 10; j++) {
                System.out.println("i : " + i +", j : " + j);
                solution(i, j);
            }
               // System.out.println(solution(i, j));
        }
*/

    }
}