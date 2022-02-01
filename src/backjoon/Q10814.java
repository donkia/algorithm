package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q10814 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<String>> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] input = bufferedReader.readLine().split(" ");
            ArrayList<String> al_temp = new ArrayList<>();
            al_temp.add(input[0]);
            al_temp.add(input[1]);
            al.add(al_temp);

        }

        Collections.sort(al, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                int n_o1 = Integer.parseInt(o1.get(0));
                int n_o2 = Integer.parseInt(o2.get(0));
                return n_o1 - n_o2;
            }
        });
        for(ArrayList print_al : al){
            System.out.println(print_al.get(0) + " " + print_al.get(1));
        }
    }
}
