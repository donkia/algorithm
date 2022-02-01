public class Weekly1 {

    static public long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }
        answer = sum - money;
        if(answer <= 0)
            return 0;

        return answer;
    }

    public static void main(String[] args) {

        int price = 3;
        int money = 20;
        int count = 4;

        System.out.println(solution(price, money, count));


    }
}
