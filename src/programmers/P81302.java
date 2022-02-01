package programmers;

import java.util.ArrayList;

public class P81302 {
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {

            String[][] map = new String[5][5];
            ArrayList<int[]> al = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                String[] temp = places[i];
                for (int k = 0; k < 5; k++) {
                    map[j][k] = temp[j].substring(k, k + 1);
                    if (map[j][k].equals("P")) {
                        al.add(new int[]{j, k});
                    }
                }
            }
            boolean success = true;
            for (int j = 0; j < al.size(); j++) {
                for (int k = j + 1; k < al.size(); k++) {

                    int[] a = al.get(j);
                    int[] b = al.get(k);

                    int dif = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);

                    if (dif > 2) {

                    } else if (dif == 2) {
                        if (a[0] == b[0]) {
                            int mid = (a[1] + b[1]) / 2;
                            if (map[a[0]][mid].equals("O")) {
                                success = false;
                                break;
                            } else if (map[a[0]][mid].equals("X")) {

                            }
                        } else if (a[1] == b[1]) {
                            int mid = (a[0] + b[0]) / 2;
                            if (map[mid][a[1]].equals("O")) {
                                success = false;
                                break;
                            } else if (map[a[1]][mid].equals("X")) {

                            }
                        } else {
                            int temp1 = Math.max(a[0], b[0]);
                            int temp2 = Math.max(a[1], b[1]);
                            if (map[temp1][temp2].equals("O") || map[temp1 - 1][temp2].equals("O") ||
                                    map[temp1 - 1][temp2 - 1].equals("O") || map[temp1][temp2 - 1].equals("O")) {
                                success = false;
                            }

                        }
                    } else {
                        success = false;
                    }
                }
            }

            if (success == true) {
                answer[i] = 1;
            } else
                answer[i] = 0;
        }
        for (int i = 0; i < 5; i++)
            System.out.println(answer[i] + " ");

        return answer;
    }


    public static void main(String[] args) {

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        solution(places);
        System.out.println();
    }
}
