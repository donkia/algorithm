package programmers;

import java.util.ArrayList;
import java.util.HashMap;

// 100점

public class CodingTest_Q1_20220501 {

    static ArrayList<String> arrayList;


    public static void DFS(String word, String[] cards, int idx, HashMap<Integer, Integer> x, HashMap<Integer, Integer> y){

        if(idx == word.length()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            System.out.println("x : "+ x);
            String temp ="";
            for(Integer num : x.keySet()){
                temp = Integer.toString(num) + Integer.toString(x.get(num)) +", ";
                //stringBuilder.append(num + x.get(num) +", ");
                stringBuilder.append(temp);
            }
            stringBuilder.append(")");

            System.out.println(stringBuilder);

            if(!arrayList.contains(stringBuilder.toString())){
                arrayList.add(stringBuilder.toString());
            }

            return ;
        }

        for(int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length(); j++) {

                if(cards[i].substring(j, j +1).equals(word.substring(idx,idx+1))){

                    if(!x.containsKey(i) && !y.containsKey(j)){

                        x.put(i, j);
                        y.put(j, i);
                        DFS(word, cards, idx +1, x, y);
                        x.remove(i);
                        y.remove(j);
                    }
                }
            }
        }

    }

    public static int solution(String word, String[] cards){

        arrayList = new ArrayList<>();

        for(int i = 0; i < cards.length; i++){
            for(int j = 0; j < cards[i].length(); j++){
                if(cards[i].substring(j, j +1).equals(word.substring(0,1))){

                    HashMap<Integer, Integer> x = new HashMap<>();
                    HashMap<Integer, Integer> y = new HashMap<>();

                    x.put(i, j);
                    y.put(j, i);

                    DFS(word, cards, 1, x, y);

                }
            }
        }
        System.out.println("arrayList : " + arrayList);
        return  arrayList.size();

    }
}
