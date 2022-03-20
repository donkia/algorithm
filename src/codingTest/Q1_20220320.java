package codingTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

public class Q1_20220320 {
    static int totalRate;

    public static class Deposit{
        LocalDate day;
        int rate;
        int money;
        int totalMoney;

        Deposit(LocalDate day, int rate, int money){
            this.day = day;
            this.rate = rate;
            this.money = money;
            this.totalMoney = 0;
        }

        public int getMoney(){
            return this.money;
        }

        public int getTotalMoney(){
            return this.totalMoney;
        }

        public int useMoney(int useMoney, LocalDate day){
            int diffDate = (day.getDayOfYear() - this.day.getDayOfYear());
            if(useMoney < this.money){
                this.money -= useMoney;
                this.totalMoney += (diffDate * this.rate * useMoney) / (365 * 100);
                return this.money;
            }
            else {
                this.totalMoney += (diffDate * this.rate * this.money) / (365 * 100);

                int tempMoney = this.money;
                this.money = 0;

                return useMoney - tempMoney;
            }
        }
        // 만기가 됐을 때 이자 계산
        public void calculateRate(){
            this.totalMoney += (((LocalDate.of(2022,12,31).getDayOfYear() - this.day.getDayOfYear())) * rate * this.money) / (365 * 100);
        }



    }


    public static int solution(String[] ledgers) {
        int answer = 0;
        Stack<Deposit> stack = new Stack<>();
        totalRate = 0;

        for(int i = 0; i < ledgers.length; i++){
            String[] ledger = ledgers[i].split(" ");
            int mm = Integer.parseInt(ledger[0].split("/")[0]);
            int dd = Integer.parseInt(ledger[0].split("/")[1]);
            int rate = Integer.parseInt(ledger[1]);
            int money = Integer.parseInt(ledger[2]);
            LocalDate localDate = LocalDate.of(2022, mm, dd);

            if(money >= 0) {
                Deposit deposit = new Deposit(localDate, rate, money);
                stack.add(deposit);
            }
            else{
                int withdrawMoney = money * -1;
                while(withdrawMoney != 0) {

                    Deposit peek = stack.peek();

                    if (peek.getMoney() <= withdrawMoney) {
                        withdrawMoney = peek.useMoney(withdrawMoney, localDate);

                        Deposit deposit = stack.pop();
                        totalRate += deposit.getTotalMoney();

                    }
                    else{
                        peek.useMoney(withdrawMoney, localDate);
                        withdrawMoney = 0;
                    }
                }

            }
        }

        while(!stack.isEmpty()){
            Deposit popDeposit = stack.pop();
            popDeposit.calculateRate();
            totalRate += popDeposit.getTotalMoney();
        }




        return totalRate;
    }


    public static void main(String[] args) {
        String[] ledgers = {
                "01/01 4 50000", "01/11 6 3555", "02/01 0 -23555", "02/25 5 5000", "03/25 0 -15000", "06/09 8 43951", "12/30 9 99999"
        };
        System.out.println(solution(ledgers));

    }


}
