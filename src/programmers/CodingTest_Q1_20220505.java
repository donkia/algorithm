package programmers;

import java.util.Stack;

//100점


public class CodingTest_Q1_20220505 {

    public static String solution(String compressed) {

        Stack<String> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        String strNum = "";

        for(int i = 0 ; i < compressed.length(); i++){

            int num = compressed.charAt(i);

            //숫자인 경우(0~9)
            if(num >= 48 && num <= 57){
                // 10이상인 숫자가 올수도 있음. '('가 나올때까지 strNum을 구함
                strNum = strNum + compressed.charAt(i);
            }

            // '(' 인 경우
            else if(num == 40){
                // '(' 앞에는 항상 숫자가 옴
                stack.add(strNum);
                stack.add(String.valueOf(compressed.charAt(i)));
                strNum = "";
            }
            // ')'인 경우 -> 반복되는 알파벳을 확인해야 함
            else if(num == 41){

                int repeatNum = 0; //반복되는 숫자 확인용
                StringBuilder reverseStr = new StringBuilder();
                // '(' 부터 ')' 사이에 어떤 소문자가 있는지 확인
                while(true){
                    String str = stack.peek();

                    if(str.equals("(")){
                        stack.pop();
                        repeatNum = Integer.parseInt(stack.pop());
                        break;
                    }
                    else{
                        reverseStr.append(stack.pop());
                    }

                }
                // 반복되는 소문자 확인
                String repeatStr = reverseStr.reverse().toString();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < repeatNum; j++){
                    temp.append(repeatStr);
                }
                // 반복되는 소문자를 구한 후에 다시 stack에 push
                for(int j = 0; j < temp.length(); j++){
                    stack.add(temp.substring(j, j+1));
                }


            }
            // 나머지 소문자인 경우
            else{
                stack.add(String.valueOf(compressed.charAt(i)));
            }
        }
        // stack 안에 있는 문자를 합해서 결과값 return
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        return answer.reverse().toString();

    }

    public static void main(String[] args) {
        String compressed = "";
        compressed = "2(3(hi)co)";
        System.out.println(solution(compressed));

        compressed = "3(hi)";
        System.out.println(solution(compressed));


        compressed = "10(p)";
        System.out.println(solution(compressed));


        compressed = "2(2(hi)2(co))x2(bo)";
        System.out.println(solution(compressed));


    }
}
