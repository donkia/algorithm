package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class P17676 {

    public static int solution(String[] lines) throws ParseException {
        int answer = 0;


        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss.SSS", Locale.KOREA);

        int[] cnt = new int[lines.length];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < lines.length; i++){
            String line = lines[i];
            String[] times = line.split(" ");
            Date endTime = f.parse(times[1]);

            for(int j = i; j < lines.length; j++){
                String[] temp = lines[j].split(" ");
                long end = endTime.getTime();
                double txTime = Double.parseDouble(temp[2].
                        substring(0, temp[2].length() - 1)) * 1000;
                long start = end - (long)txTime + 1;

                Date startTime = new Date(start);

                if(start < end + 1000){
                    cnt[i] = cnt[i] + 1;
                    if(max < cnt[i]){
                        max = cnt[i];
                    }
                }
            }
        }
        answer = max;
        return answer;
    }


    public static void main(String[] args) throws ParseException {

        String[] lines = {
        /*        "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        */"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"

        };

        System.out.println(solution(lines));

    }


}
