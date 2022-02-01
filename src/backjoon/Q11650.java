package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] s = bufferedReader.readLine().split(" ");
            int a1 = Integer.parseInt(s[0]);
            int a2 = Integer.parseInt(s[1]);
            ArrayList<Integer> al_temp = new ArrayList<>();
            al_temp.add(a1);
            al_temp.add(a2);
            al.add(al_temp);
        }
        Collections.sort(al, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(!o1.get(0).equals(o2.get(0))) {
                    return o1.get(0).compareTo(o2.get(0));
                }
                else return o1.get(1).compareTo(o2.get(1));
                /*if (o1.get(0) > o2.get(0)) {
                    return 1;
                } else if (o1.get(0) == o2.get(0)) {

                    if (o1.get(1) > o2.get(1))
                        return 1;
                    else
                        return -1;
                } else {

                    return -1;
                }*/
            }
        });
        for(ArrayList al_print : al){
            System.out.println(al_print.get(0) + " " + al_print.get(1));
        }
    }
}
