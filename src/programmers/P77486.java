package programmers;
import java.util.HashMap;
import java.util.LinkedHashMap;
/** 프로그래머스 '다단계 칫솔 판매' 문제(level3) [https://programmers.co.kr/learn/courses/30/lessons/77486]
 *  해결
 * */
public class P77486 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // 사람과 이익을 매칭하는 map 생성(배열에 담긴 사람의 순서를 유지하기 위해서 LinkedHashMap 선언)
        LinkedHashMap<String, Integer> profit = new LinkedHashMap<>();
        // 판매원과 추천인을 매칭한 map 생성
        HashMap<String, String> matchPerson = new HashMap<>();
        // map에 초기값 셋팅
        for(int i = 0; i < enroll.length; i++){
            profit.put(enroll[i], 0);
            matchPerson.put(enroll[i], referral[i]);
        }
        // 민호(-) 도 추가
        profit.put("-", 0);
        matchPerson.put("-", "-");

        for(int i = 0; i < seller.length; i++){

            String sellerPerson = seller[i];
            int money = amount[i] * 100;
            String helper = matchPerson.get(sellerPerson);

            while(!sellerPerson.equals("-")){
                int personProfit = 0;

                personProfit = money;
                money = (int) (money * 0.1);
                personProfit = personProfit - money;

                //판매원 이익을 계산 후 map에 insert
                int getProfit = profit.get(sellerPerson);
                profit.put(sellerPerson, getProfit + personProfit);

                //판매원의 추천인을 찾음
                sellerPerson = helper.toString();
                helper = matchPerson.get(sellerPerson).toString();
                // 10퍼센트 남은금액이 10원보다 적거나 or 추천인이 민호(-) 일때 반복문 종료
                if(money < 10 || sellerPerson.equals("-")){
                    int getHelperProfit = profit.get(sellerPerson);
                    profit.put(sellerPerson, getHelperProfit + money);
                    break;
                }
            }
        }
        profit.remove("-"); //민호(-)는 출력되면 안되니 제거
        int idx = 0;
        for(String name : profit.keySet()){
            answer[idx++] = profit.get(name);
        }
        return answer;
    }


    public static void main(String[] args) {

        String[] enroll = {
                "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
        };

        String[] referral = {
                "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
        };

        String[] seller = {
                "young", "john", "tod", "emily", "mary"
        };

        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(solution(enroll, referral, seller, amount));

    }
}

