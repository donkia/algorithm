package backjoon;

import java.util.*;

public class Q2751 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            al.add(Integer.parseInt(sc.nextLine()));
        }

        Collections.sort(al);

        for(int i = 0; i < n ; i++){
            sb.append(al.get(i));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

