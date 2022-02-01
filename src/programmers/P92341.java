package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class P92341 {

    public static long[] solution(int[] fees, String[] records) throws ParseException {
        ArrayList<Long> alFee = new ArrayList<>();

        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, Long> price = new HashMap<>();
        ArrayList<String> order = new ArrayList<>();

        for(int i = 0; i < records.length; i++){
            String[] splitRecord = records[i].split(" ");

            if(splitRecord[2].equals("IN")){
                hm.put(splitRecord[1], splitRecord[0]);
            }
            else{
                String inTime = hm.get(splitRecord[1]);
                String outTime = splitRecord[0];

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date DateinTime = dateFormat.parse(inTime);
                long longInTime = DateinTime.getTime();

                Date DateOutTime = dateFormat.parse(outTime);
                long longOutTime = DateOutTime.getTime();

                long minute = (longOutTime - longInTime) / 60000;
                //System.out.println("OutTime : " + outTime +", inTime : " + inTime +", minute : " + minute);

                if(hm.containsKey(splitRecord[1]))
                    hm.remove(splitRecord[1]);

                if(price.containsKey(splitRecord[1])){
                    long num = price.get(splitRecord[1]);
                    price.put(splitRecord[1], num + minute);
                }
                else{
                    price.put(splitRecord[1], minute);
                }
                if(!order.contains(splitRecord[1]))
                    order.add(splitRecord[1]);
            }
        }

        if(hm.size() >= 1) {
            for (String s : hm.keySet()) {
                String inTime = hm.get(s);
                String outTime = "23:59";

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date DateinTime = dateFormat.parse(inTime);
                long longInTime = DateinTime.getTime();

                Date DateOutTime = dateFormat.parse(outTime);
                long longOutTime = DateOutTime.getTime();
                long minute = (longOutTime - longInTime) / 60000;
                if(price.containsKey(s)){
                    long num = price.get(s);
                    price.put(s, num + minute);
                }
                else{
                    price.put(s, minute);
                }
                if(!order.contains(s))
                    order.add(s);
            }
        }
        Collections.sort(order);
        for(String carNum : order){
            long time = price.get(carNum);
            long money = 0;
            if(time <= fees[0]){
                money = fees[1];
            }
            else{
                if((time - fees[0]) % fees[2] != 0){
                    money = (fees[1] + (((time - fees[0]) / fees[2]) +1) * fees[3]);
                }
                else
                    money = (fees[1] + (time - fees[0]) / fees[2] * fees[3]);
            }
            alFee.add(money);
        }
        System.out.println("2hm : " + hm);
        System.out.println("2price : " + price);
        System.out.println("2order : " + order);

        System.out.println(alFee);

        long[] answer = new long[alFee.size()];
        int idx = 0;
        for(Long i : alFee){
            answer[idx] = i;
            idx++;
        }


        return answer;
    }


    public static void main(String[] args) throws ParseException {
        //기본시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        int[] fees = {10, 461, 1, 10};
        String[] records = {"23:57 1234 IN", "23:57 1233 OUT"};

        System.out.println(solution(fees, records));

    }
}
