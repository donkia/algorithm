package programmers;

import java.lang.reflect.Array;
import java.util.*;

public class P72412 {

    static HashMap<String, ArrayList<Integer>> hs;

    public static void DFS(String key, String[] person, int  cnt){
        if(cnt == 4){
            if(hs.containsKey(key)){
                hs.get(key).add(Integer.parseInt(person[4]));
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(person[4]));
                hs.put(key, temp);
            }
            return ;
        }
        DFS( key + "-", person, cnt + 1);
        DFS( key + person[cnt], person, cnt + 1);
    }


    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hs = new HashMap<>();

        // info정보를 applicants 클래스 배열에 대입
        for (int i = 0; i < info.length; i++) {
            String[] person = info[i].split(" ");
            DFS("", person, 0);
            //DFS(0, person[0], person, 1);
        }
        /** Map에 list값들을 정렬 ------> 이부분을 추가하니 효율성에서 통과함 */
        for(String key : hs.keySet()){
            Collections.sort(hs.get(key));
        }

        // query 정보로 비교
        for(int i = 0; i < query.length; i++){
            String[] temp = query[i].split(" and ");
            String[] querys = new String[5];
            querys[0] = temp[0];
            querys[1] = temp[1];
            querys[2] = temp[2];

            String[] split = temp[3].split(" ");
            querys[3] = split[0];
            querys[4] = split[1];

            StringBuilder key = new StringBuilder(querys[0]);
            key.append(querys[1]);
            key.append(querys[2]);
            key.append(querys[3]);

            if (hs.containsKey(key.toString())) {
                ArrayList<Integer> value = hs.get(key.toString());
                /** 효율성에서 0점 나와서 이 부분 주석하고 line 35 추가하니 해결 */
                //Collections.sort(value);
                int num = BinarySearch(value, Integer.parseInt(querys[4]));
                answer[i] = value.size() - num;
            }
        }
        return answer;
    }

    public static int BinarySearch(ArrayList<Integer> al, int key){

        int first = 0;
        int last = al.size()-1;

        while(first <= last){
            int mid = (first + last) / 2;
           if(al.get(mid) < key){
                first = mid+1;
            }
            else{
                last = mid-1;
            }
        }
        return first;
    }

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        System.out.println(solution(info, query));

    }

}
