package programmers;

import java.util.*;
public class P42890 {
    static ArrayList<String> al = new ArrayList<>();
    // 1. 단어들 조합 후 al에 저장
    public static void DFS(String[][] relation, int[] isUsed, int n) {
        ArrayList<String> al_temp = new ArrayList<>();
        Boolean isTrue = true;
        for(int i = 0; i < relation.length; i++){
            String str = "";
            for(int j = 0; j < isUsed.length; j++){
                if(isUsed[j] == 1){
                    str = str + relation[i][j];
                }
            }
            if (al_temp.contains(str)) {
                isTrue = false;
                break;
            }
            else al_temp.add(str);
        }
        if(isTrue == true){
            String strIsUsed= "";
            for(int i = 0; i < isUsed.length; i++){
                if(isUsed[i] == 1)
                    strIsUsed = strIsUsed + i;
            }
            if (al.isEmpty())
                al.add(strIsUsed);
            else {
                al.add(strIsUsed);
            }
        }
        for(int i = n+1; i < isUsed.length; i++){
            if(isUsed[i] == 0){
                isUsed[i] = 1;
                DFS(relation, isUsed, i);
                isUsed[i] = 0;
            }
            else
                continue;
        }
    }

    public static int solution(String[][] relation) {
        int answer = 0;
        int rowCnt = relation.length;

        int[] arr = new int[rowCnt];
        for(int i = 0; i < rowCnt; i++){
            arr[i] = i;
        }
        // 0. 1개가 key인 경우 미리 구해둠
        for (int i = 0; i < relation[0].length; i++) {
            Boolean isDuplicate = true;
            ArrayList<String> al_temp = new ArrayList<>();
            for (int j = 0; j < rowCnt; j++) {

                String strTemp = relation[j][i];
                if (al_temp.contains(strTemp)) {
                    isDuplicate = false;
                    break;
                } else {
                    al_temp.add(strTemp);
                }
            }
            if (isDuplicate == true) {
                al.add(i + "");
            }
        }
        int[] isUsed = new int[relation[0].length];
        // 1. DFS로 2개이상 컬럼 조합을 구함.
        for(int i = 0; i < isUsed.length; i++){
            isUsed[i] = 1;
            DFS(relation,  isUsed, i);
            isUsed[i] = 0;
        }
        // 2. DFS에서 구한 값들은 al에 저장. 중복된 항목들을 제거하기 위해 al을 sort함
        Collections.sort(al, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else
                    return o1.length() - o2.length();
            }
        });
        // 중복된 항목들을 제거. 만약 컬럼0+1+2가 후보키 인데, 02도 후보키인 경우 012는 삭제되어야 함. 이것때문에 테스트케이스 몇개 실패.
        for(int i = 0; i < al.size(); i++) {
            if (al.get(i).equals("")) continue;
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(j).equals("")) continue;

                char[] ch_j = al.get(j).toCharArray();
                char[] ch_i = al.get(i).toCharArray();

                int same = 0;
                for(int k = 0; k < ch_i.length; k++){
                    for(int m = 0; m < ch_j.length; m++){
                        if(ch_i[k] == ch_j[m]){
                            same ++;
                        }
                    }
                }
                if(same == ch_i.length){
                    al.set(j, "");
                }
            }
        }
        for(int i = 0; i < al.size(); i++)
            if(!al.get(i).equals("")) answer++;
        return answer;
    }

    public static void main(String[] args) {

        String[][] relation = {
/*
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}

 */
                {"a", "1", "aaa", "c", "ng"},
                {"a", "1", "bbb", "e", "g"},
                {"c", "1", "aaa", "d", "ng"},
                {"d", "2", "bbb", "d", "ng"}


        };

        System.out.println(solution(relation));

    }
}
