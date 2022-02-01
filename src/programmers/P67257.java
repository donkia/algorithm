package programmers;

public class P67257 {
    static Long maxNum = Long.MIN_VALUE;
    static public void priorityPlus(String expression, String op1, String op2, String op3) {
        // op1, op2, op3에 따라서 6가지 operatino으로 인해 분기 시킴
        String[] strOperation1 = expression.split(op1);
        Long sum = 0L;

        for (int i = 0; i < strOperation1.length; i++) {
            String[] strOperation2 = strOperation1[i].split(op2);
            for (int j = 0; j < strOperation2.length; j++) {
                Long temp = 1L;

                if(op3.equals("\\*")) {
                    if (strOperation2[j].contains("*")) {
                        String[] strOperation3 = strOperation2[j].split("\\*");
                        temp = 1L;
                        for (int k = 0; k < strOperation3.length; k++) {
                            temp = temp * Long.parseLong(strOperation3[k]);
                        }
                        strOperation2[j] = Long.toString(temp);
                    }
                }else if(op3.equals("\\+")){
                    if (strOperation2[j].contains("+")) {
                        String[] strOperation3 = strOperation2[j].split("\\+");
                        temp = 0L;
                        for (int k = 0; k < strOperation3.length; k++) {
                            temp = temp + Long.parseLong(strOperation3[k]);
                        }
                        strOperation2[j] = Long.toString(temp);
                    }
                }
                else if(op3.equals("\\-")){
                    if (strOperation2[j].contains("-")) {
                        String[] strOperation3 = strOperation2[j].split("\\-");
                        temp = Long.parseLong(strOperation3[0]);
                        for (int k = 1; k < strOperation3.length; k++) {
                            temp = temp - Long.parseLong(strOperation3[k]);
                        }
                        strOperation2[j] = Long.toString(temp);
                    }
                }
            }
            if(op2.equals("\\-")){
                Long sumMinums = Long.parseLong(strOperation2[0]);
                for (int j = 1; j < strOperation2.length; j++) {
                    sumMinums = sumMinums - Long.parseLong(strOperation2[j]);
                }
                strOperation1[i] = Long.toString(sumMinums);
            }
            else if(op2.equals("\\+")){
                Long sumPlus = 0L;
                for (int j = 0; j < strOperation2.length; j++) {
                    sumPlus = sumPlus + Long.parseLong(strOperation2[j]);
                }
                strOperation1[i] = Long.toString(sumPlus);
            }
            else if(op2.equals("\\*")){
                Long sumMul = 1L;
                for (int j = 0; j < strOperation2.length; j++) {
                    sumMul = sumMul * Long.parseLong(strOperation2[j]);
                }
                strOperation1[i] = Long.toString(sumMul);
            }

            if(op1.equals("\\-")) {
                if(i == 0) sum = Long.parseLong(strOperation1[0]);
                else
                    sum -= Long.parseLong(strOperation1[i]);
            }
            else if(op1.equals("\\*")) {
                if(i == 0) sum = 1L;
                else
                    sum *= Long.parseLong(strOperation1[i]);
            }
            else if(op1.equals("\\+")){
                if(i==0) sum = 0L;
                else
                    sum += Long.parseLong(strOperation1[i]);
            }
        }
        if (maxNum < Math.abs(sum)) {
            maxNum = Math.abs(sum);
        }
    }

    static public long solution(String expression) {
        long answer = 0;
        priorityPlus(expression, "\\-", "\\+", "\\*");
        priorityPlus(expression, "\\+", "\\-", "\\*");
        priorityPlus(expression, "\\*", "\\+", "\\-");
        priorityPlus(expression, "\\*", "\\-", "\\+");
        priorityPlus(expression, "\\-", "\\*", "\\+");
        priorityPlus(expression, "\\+", "\\*", "\\-");

        answer = maxNum;
        return answer;
    }


    public static void main(String[] args) {
        //String expression = "100-200*300-500+20";
        String expression = "50*6-3*2";


        System.out.println(solution(expression));
    }


}
