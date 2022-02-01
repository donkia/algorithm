package backjoon;

import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7569 {

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);

        //int m = sc.nextInt();
        String num = sc.nextLine();
        String[] arrNum = num.split(" ");
        int m = Integer.parseInt(arrNum[0]);
        int n = Integer.parseInt(arrNum[1]);
        int h = Integer.parseInt(arrNum[2]);

        int[][][] map = new int[n][m][h];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < h ; i++){
            for(int j = 0; j < n; j++){
                num = sc.nextLine();
                String []temp = num.split(" ");
                for(int k = 0; k < m; k++){
                    map[j][k][i] = Integer.parseInt(temp[k]);

                    if(map[j][k][i] == 1){
                        queue.add(new int[]{j, k, i});
                    }
                }
            }
        }

       /* for(int i = 0; i < h ; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    System.out.print(map[j][k][i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }*/

        int cnt = 0;
        while(!queue.isEmpty()){

            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int z = queue.peek()[2];

            if(cnt < map[x][y][z]){
                cnt = map[x][y][z];
            }
            queue.poll();

            if(x > 0 && map[x-1][y][z] == 0){
                queue.add(new int[]{x-1, y, z});
                map[x-1][y][z] = map[x][y][z]+1;
            }

            if(x < n-1 && map[x+1][y][z] == 0){
                queue.add(new int[]{x+1, y, z});
                map[x+1][y][z] = map[x][y][z]+1;
            }

            if(y > 0 && map[x][y-1][z] == 0){
                queue.add(new int[]{x, y-1, z});
                map[x][y-1][z] = map[x][y][z]+1;
            }
            if(y < m-1 && map[x][y+1][z] == 0){
                queue.add(new int[]{x, y+1, z});
                map[x][y+1][z] = map[x][y][z]+1;
            }
            if(z > 0 && map[x][y][z-1] == 0){
                queue.add(new int[]{x, y, z-1});
                map[x][y][z-1] = map[x][y][z]+1;
            }
            if(z < h-1 && map[x][y][z+1] == 0){
                queue.add(new int[]{x, y, z+1});
                map[x][y][z+1] = map[x][y][z]+1;
            }
        }
        cnt = cnt - 1;

       /* System.out.println("------------------------------------------");
        for(int i = 0; i < h ; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    System.out.print(map[j][k][i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }*/

        for(int i = 0; i < h ; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(map[j][k][i] == 0){
                        cnt = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);


    }
}
