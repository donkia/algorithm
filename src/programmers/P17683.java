package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class P17683 {
    // String[] 을 ArrayList로 변환. #으로된 알파벳이 존재해서 arr->List 로 변환
    public static ArrayList<String> arrToList(String song){
        ArrayList<String> al = new ArrayList<>();

        for(int j = 0; j < song.length()-1; j++){
            if(song.substring(j, j+1).equals("#")){
                continue;
            }
            if(song.substring(j+1, j + 2).equals("#")){
                al.add(song.substring(j, j + 2));
            }
            else
                al.add(song.substring(j, j + 1));
        }
        if(!song.substring(song.length()-1).equals("#")){
            al.add(song.substring(song.length()-1));
        }
        return al;
    }

    // #으로된 알파벳을 다른 단어로 치환
    public static String convert(ArrayList<String> al) {
        String str = "";
        for (int i = 0; i < al.size(); i++) {

            if (al.get(i).equals("C#")) str += "1";
            else if (al.get(i).equals("D#")) str += "2";
            else if (al.get(i).equals("F#")) str += "3";
            else if (al.get(i).equals("G#")) str += "4";
            else if (al.get(i).equals("A#")) str += "5";
            else str += al.get(i);
        }
        return str;
    }

    // 시간차이 구하기
    public static Long calculateMinute(String startTime, String endTime) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date start = dateFormat.parse(startTime);
        Date end = dateFormat.parse(endTime);
        long lStart = start.getTime();
        long lEnd = end.getTime();
        long minute = (lEnd - lStart) / 60000; //분 단위로 변경
        return minute;
    }

    public static String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "";
        long min = 0;

        for(int i = 0 ; i < musicinfos.length; i++){

            String musicinfo = musicinfos[i];
            String[] infos = musicinfo.split(",");

            String startTime = infos[0];
            String endTime = infos[1];
            String title = infos[2];
            String song = infos[3];

            Long minute = calculateMinute(startTime, endTime); // 몇분차인지 구하기

            //악보정보 중 #으로 되어있는 단어들 때문에 ArrayList에 # 포함됐는지 안됐는지 판단 후 ArrayList에 add
            ArrayList<String> al = arrToList(song);
            // 멜로디 문자열 m에도 #이 포함되어있는지 안되어 있는지 판단 후 ArrayList에 add
            ArrayList<String> m_al = arrToList(m);

            // minute의 수 만큼 악보정보 나열
            int idx = 0;
            ArrayList<String> al_music = new ArrayList<>();
            for(int j = 0; j < minute; j++){
                if(idx >= al.size()){
                    idx = 0;
                }
                al_music.add(al.get(idx));
                idx ++;
            }
            //나열된 악보정보에 m이 포함되는지 안되는지 체크(# 으로 된 부분은 convert 함수를 통해 다른 문자로 치환한 상태)
            if(convert(al_music).contains(convert(m_al))){
                if(answer.equals("")) answer = title;
                //[문제조건] 조건이 일치하는 음악이 여러개 일때, 재생된 시간이 제일 긴 음악제목 반환
                if(min < minute){
                    answer = title;
                    min = minute;
                }
                //[문제조건] 재생된 시간이 같을 경우 먼저 입력된 음악 제목을 반환
                else if(min == minute){
                }
            }
        }
        //[문제조건] 조건이 일치하는 음악이 없을 때는 (None) 을 반환
        if(answer.equals(""))
            answer = "(None)";

        return answer;
    }

    public static void main(String[] args) throws ParseException {


        String[] musicinfos = {
         //       "12:00,13:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"
                "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:02,WORLD,ABCDEF"
        };

        String m = "ABC";
        System.out.println(solution(m, musicinfos));
    }
}
