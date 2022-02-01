package programmers;

import java.util.Stack;
public class P60058 {
    /** 문자열이 균형잡힌, 올바른 괄호 문자열인지 판단
     *  EMPTY : 빈 문자열("")
     *  RIGHT : 올바른 괄호 문자열
     *  BALANCED : 균형잡힌 괄호 문자열
     *  NONE : 아무것도 아님
     * */
    public static String isBalanced(String s){
        if(s.equals("")){
            return "EMPTY";
        }
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            String temp = s.substring(i, i + 1);
            if(stack.isEmpty()){
                stack.add(temp);
            }
            else{
                String peek = stack.peek();
                if(temp.equals(")")){
                    if(peek.equals("(")){
                        stack.pop();
                    }
                    else
                        stack.add(temp);
                }
                else{
                    stack.add(temp);
                }
            }
        }
        if(stack.isEmpty()){ // stack이 비어있으면 '올바른 괄호 문자열'
            return "RIGHT";
        }
        // stack이 비어있지않으면 '(' 와 ')' 갯수를 파악해서 같으면 BALANCED 문자열
        int cntRight = 0;
        int cntLeft = 0;
        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i).equals("(")){
                cntLeft ++;
            }
            else
                cntRight++;
        }
        if(cntLeft == cntRight){
            return "BALANCED";
        }
        else{
            return "NONE";
        }
    }
    // 재귀를 통해서 u와 v를 구하는 메서드
    public static String calculateUandV(String p){
        if(p.equals("")){
            return "";
        }
        String u = "";
        String v = "";
        // 문자열 p에서 u와 v를 구하기
        for (int i = 0; i < p.length(); i++) {
            StringBuilder sb = new StringBuilder(p.substring(0, i+1));
            if (isBalanced(sb.toString()).equals("BALANCED") || isBalanced(sb.toString()).equals("RIGHT")) {
                u = p.substring(0, i + 1);
                v = p.substring(i+1);
                break;
            }
        }
        // u가 올바른 괄호 문자열 일때
        if(isBalanced(u).equals("RIGHT")){
            return u + calculateUandV(v);
        }
        // 만약 u가 올바른 괄호 문자열이 아니면
        else{
            String temp = "(" + calculateUandV(v) + ")";
            for(int i = 1; i < u.length()-1; i++){
                if(u.substring(i, i+1).equals("(")){
                    temp = temp + ")";
                }
                else
                    temp = temp + "(";
            }
            return temp;
        }
    }
    public static String solution(String p) {
        String answer = "";
        // p가 올바른 괄호 문자열일때
        if(isBalanced(p).equals("RIGHT")){
            return p;
        }
        // p가 올바른 괄호 문자열이 아닐 때
        answer = calculateUandV(p);
        return answer;
    }

    public static void main(String[] args) {

        //String p = "(()())()";
        //String p = ")(";
        String p = "()))((()";



        System.out.println(solution(p));

    }
}
