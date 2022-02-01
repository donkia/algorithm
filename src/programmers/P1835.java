package programmers;

public class P1835 {
    static int answer;
    // 8개 문자를 조합하는 DFS 함수
    public static void DFS(String[] data, int n, String[] group, String[] dfs_group, int cnt) {
        // 8개 문자가 다 조립됐을 때
        if (cnt == 8) {
            boolean isRight = true;
            for (int i = 0; i < n; i++) {
                String character1 = data[i].substring(0, 1);
                String character2 = data[i].substring(2, 3);
                String character4 = data[i].substring(3, 4);
                int num = Integer.parseInt(data[i].substring(4, 5));

                int idx_character1 = 0;
                int idx_character2 = 0;
                for (int j = 0; j < 8; j++) {
                    if (dfs_group[j].equals(character1)) {
                        idx_character1 = j;
                    }
                    if (dfs_group[j].equals(character2)) {
                        idx_character2 = j;
                    }
                }
                int diff = Math.abs(idx_character1 - idx_character2)-1;
                if (character4.equals("=")) {
                    if (num == diff) {

                    } else {
                        isRight = false;
                        break;
                    }
                } else if (character4.equals(">")) {
                    if (diff > num) {

                    } else {
                        isRight = false;
                        break;
                    }
                } else if (character4.equals("<")) {
                    if (diff < num) {

                    } else {
                        isRight = false;
                        break;
                    }
                }
            }
            if (isRight == true) {
                answer++;
                /*for(int k = 0; k < dfs_group.length; k++){
                    System.out.print(dfs_group[k] + " ");
                }
                System.out.println();*/
            }
            return;
        }

        for (int i = 0; i < group.length; i++) {

            if (!group[i].equals("")) {
                dfs_group[cnt] = group[i];
                String temp = group[i].toString();
                group[i] = "";
                DFS(data, n, group, dfs_group, cnt + 1);
                group[i] = temp;
            }
        }
    }

    public static int solution(int n, String[] data) {

        String[] group = {"A", "C", "F", "J", "M", "N", "R", "T"};
        answer = 0;
        for (int i = 0; i < group.length; i++) {
            String[] temp_group = new String[group.length];
            temp_group[0] = group[i];

            String temp = group[i].toString();
            group[i] = "";
            DFS(data, n, group, temp_group, 1);
            group[i] = temp;
        }
        return answer;
    }

    public static void main(String[] args) {

        int n = 2;
        String[] data = {
           //     "N~F=0", "R~T>2"
                "M~C<2", "C~M>1"
        };
        System.out.println(solution(n, data));

    }
}
