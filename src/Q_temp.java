import java.util.ArrayList;
import java.util.Collections;

public class Q_temp {
    static String[][] map;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> al = new ArrayList<>();

    public static void findnear(int m, int n){

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j].equals(".") || map[i][j].equals("*")) continue;


                if(i < m-1){
                    if(map[i][j].equals(map[i+1][j]) && !map[i][j].equals(".")){
                        //sb.append(map[i][j]);
                        al.add(map[i][j]);
                        map[i][j] = ".";
                        map[i+1][j] = ".";
                    }
                }
                if(i > 0){
                    if(map[i][j].equals(map[i-1][j]) && !map[i][j].equals(".")){
                        //sb.append(map[i][j]);
                        al.add(map[i][j]);

                        map[i][j] = ".";
                        map[i-1][j] = ".";
                    }
                }
                if(j > 0){
                    if(map[i][j].equals(map[i][j-1]) && !map[i][j].equals(".")){
//                        sb.append(map[i][j]);
                        al.add(map[i][j]);

                        map[i][j] = ".";
                        map[i][j-1] = ".";
                    }
                }
                if(j < n-1){
                    if(map[i][j].equals(map[i][j+1]) && !map[i][j].equals(".")){
//                        sb.append(map[i][j]);
                        al.add(map[i][j]);

                        map[i][j] = ".";
                        map[i][j+1] = ".";
                    }
                }
            }
        }
    }

    public static void BFS(int m, int n, int i, int j, String s, int start, int end, int[][] visit){

        if(!map[i][j].equals(".")){
            if(!s.equals(map[i][j]))
                return;
            else if(i == start && j == end){

            }
            else if(s.equals(map[i][j])){
                al.add(s);
                //sb.append(s);
                map[i][j] = ".";
                map[start][end] = ".";
                return;
            }

        }


        if(i < m-1){
            if(!map[i+1][j].equals("*") && visit[i+1][j] == 0){
                visit[i+1][j] = 1;
                BFS(m, n, i+1, j, s, start, end, visit);
                visit[i+1][j] = 0;

            }
        }
        if(i > 0){
            if(!map[i-1][j].equals("*") && visit[i-1][j] == 0){
                visit[i-1][j] = 1;

                BFS(m, n, i-1, j, s, start, end, visit);
                visit[i-1][j] = 0;
            }
        }
        if(j > 0){
            if(!map[i][j-1].equals("*")&& visit[i][j-1] == 0){
                visit[i][j-1] = 1;
                BFS(m, n, i, j-1, s, start, end, visit);
                visit[i][j-1] = 0;
            }

        }
        if(j < n-1){
            if(!map[i][j+1].equals("*") && visit[i][j+1] == 0){
                visit[i][j+1] = 1;
                BFS(m, n, i, j+1, s, start, end, visit);
                visit[i][j+1] = 0;
            }
        }

    }



    public static String solution(int m, int n, String[] board) {
        String answer = "";
        map = new String[m][n];


        for(int i = 0; i < m; i++){
            String temp = board[i];
            for(int j = 0; j < n; j++){
                map[i][j] = temp.substring(j, j + 1);
            }
        }

        findnear(m, n);
        Collections.sort(al);
        for(String s : al){
            sb.append(s);
        }
        al.clear();

        int[][] visit = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!map[i][j].equals(" ") && !map[i][j].equals("*") && !map[i][j].equals("."))
                    visit[i][j] = 1;
                    BFS(m, n, i, j, map[i][j], i, j, visit);
                    visit[i][j] = 0;
            }
        }
        Collections.sort(al);
        for(String s : al){
            sb.append(s);
        }
        al.clear();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(sb);
        if(sb.toString().equals(""))
            return "IMPOSSIBLE";
        return sb.toString();
    }

    public static void main(String[] args) {

       /* int m = 3;
        int n = 3;
        String[] board = {
               "DBA", "C*A", "CDB"
        };*/

        /*int m = 2;
        int n = 4;
        String[] board = {
               "NRYN", "ARYA"
        };*/

        int m = 4;
        int n = 4;
        String[] board = {
                ".ZI.", "M.**", "MZU.", ".IU."
        };

       /* int m = 2;
        int n = 2;
        String[] board = {
                "AB", "BA"
        };*/


        System.out.println(solution(m, n, board));


    }
}
