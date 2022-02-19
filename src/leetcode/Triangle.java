package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 문제 : https://leetcode.com/problems/triangle/
 *  레벨 : Medium
 *  결과 : 해결(runtime 5ms faster than 52.76%, memory 44.9MB less than 5.19%)
 * */

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        long[][] map = new long[triangle.size()][triangle.size()];

        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }

        map[0][0] = triangle.get(0).get(0);
        map[1][0] = map[0][0] + triangle.get(1).get(0);
        map[1][1] = map[0][0] + triangle.get(1).get(1);

        for(int i = 2; i < triangle.size(); i++){

            for(int j = 0; j < i+1; j++){
                if(j == i)
                    map[i][j] = triangle.get(i).get(j) + map[i-1][j-1];
                else if(j== 0)
                    map[i][j] = triangle.get(i).get(j) + map[i - 1][j];
                else
                    map[i][j] = triangle.get(i).get(j) + Math.min(map[i - 1][j], map[i-1][j-1]);

            }
        }

        long min = Long.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++){
            if(map[triangle.size()-1][i] < min){
                min = map[triangle.size() - 1][i];
            }
        }

        return (int)min;

    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);

        triangle.add(al);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(3);
        al2.add(4);
        triangle.add(al2);

        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(6);
        al3.add(5);
        al3.add(7);
        triangle.add(al3);

        ArrayList<Integer> al4 = new ArrayList<>();
        al4.add(4);
        al4.add(1);
        al4.add(8);
        al4.add(3);
        triangle.add(al4);


        System.out.println(minimumTotal(triangle));

    }


}
