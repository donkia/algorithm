package programmers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CodingTest_Q2_20220319 {

    public static int[] solution(String s, String[] times) {
        int[] answer = {};

        // 31일인 달(1,3,5,7,8,10,12월)일수도 있으니 30일인 달(4월)로 임시 변경
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.replace(5, 7, "04");
        s = stringBuilder.toString();

        LocalDateTime firstSavedDate = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss").withLocale(Locale.KOREA));
        LocalDateTime nextSavedDate = firstSavedDate;
        LocalDateTime lastSavedDate = firstSavedDate;
        boolean isTrue = true;



        for(int i = 0; i < times.length; i++){
            String[] time = times[i].split(":");

            nextSavedDate = lastSavedDate.plus(Integer.parseInt(time[3])  + Integer.parseInt(time[2]) * 60 + Integer.parseInt(time[1]) * 60 * 60 + Integer.parseInt(time[0]) * 60 * 60 * 24, ChronoUnit.SECONDS);

            long difDay = nextSavedDate.getDayOfYear() - lastSavedDate.getDayOfYear();
            if(difDay > 1 || difDay < 0){
                isTrue = false;
            }
            lastSavedDate = nextSavedDate;
        }

        int difDay = lastSavedDate.getDayOfYear() - firstSavedDate.getDayOfYear()+1;
        //1년은 360일로 가정
        if(difDay < 0){
            difDay = difDay + 360;
        }
        if(isTrue == false) {
            return new int[]{0, difDay};
        }
        else {
            return new int[]{1, difDay};
        }
    }


    public static void main(String[] args) {
        /*String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "01:04:12:00"};
        */
        String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "01:04:12:00"};

        System.out.println(solution(s, times).toString());
    }
}
