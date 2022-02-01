package programmers;

public class P12899 {
    public static String solution(int n) {
/*
        처음에 풀었던 풀이. 정확성은 100점이지만 효율성에서 0점(시간초과)
        String answer = "";
        ArrayList<String> al = new ArrayList<>();
        al.add("1");
        al.add("2");
        al.add("4");
        int start = 0;
        int end = al.size();
        while(al.size() <= n){
            for(int i = start; i < end; i++){
                String temp = "1"+al.get(i);
                al.add(temp);
            }
            for(int i = start; i < end; i++){
                String temp = "2"+al.get(i);
                al.add(temp);
            }
            for(int i = start; i < end; i++){
                String temp = "4"+al.get(i);
                al.add(temp);
            }
            start = end;
            end = al.size();
        }
        answer = al.get(n - 1);
        */
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int remain = n % 3;
            if(remain == 0){
                sb.append("4");
                n = n - 1; //나머지가 0일 때 n을 -1 해줘야함;;
            }
            else {
                sb.append(remain);
            }
            n = n / 3;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(solution(3));

    }
}
