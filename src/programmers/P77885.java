package programmers;

public class P77885 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            StringBuilder binaryNum = new StringBuilder(Long.toBinaryString(num).toString());
            // 마지막에 0으로 끝나면 num에 +1 해주기
            if (binaryNum.substring(binaryNum.length() - 1, binaryNum.length()).equals("0")) {
                answer[i] = num + 1;
            } // 마지막에 1로 끝났을경우
            else {
                //숫자가 전부 1인지 찾기
                boolean isAllOne = true;
                int cntOne = 0;
                for(int j = 0; j < binaryNum.length(); j++){
                    if(binaryNum.substring(j, j+1).equals("0")){
                        isAllOne = false;
                        break;
                    }
                    else{
                        cntOne ++;
                    }
                }
                // 전부 다 1이면
                if(isAllOne == true){
                    answer[i] = (long) (Math.pow(2, (cntOne - 1)) + num);
                }
                // 전부 다 1이 아니면, 맨 뒤에서부터 01이면 10로 변경
                // 10이면 01로 변경
                else{
                    for(int j = binaryNum.length()-1; j >= 0; j--){
                        if(binaryNum.substring(j-1, j+1).equals("01")){
                            binaryNum.replace(j - 1, j + 1, "10");
                            break;
                        }
                    }
                    num = Long.parseLong(String.valueOf(binaryNum), 2);
                    answer[i] = num;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        long[] numbers = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18};

        System.out.println(solution(numbers));

    }
}
