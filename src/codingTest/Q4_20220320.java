package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Q4_20220320 {

    public static class Node{

        Node prev;
        List<Node> next;
        String name;

        Node(String name){
            this.prev = null;
            this.name = "name";
            this.next = new ArrayList<>();
        }

        public void setNext(Node next){
            this.next.add(next);
        }

        public boolean getDuplicate(String location){
            return next.contains(location);
        }


    }


    public static String[] solution(String[] directory, String[] command) {
        String[] answer = {};
        Node rootNode = new Node("rootNode");

        for(int i = 0; i < directory.length; i++){
            String location = directory[i];

            if(location.equals("/")){
            }
            else{
                String[] split = location.substring(1).split("/");

                if (split.length == 1){
                    if(!rootNode.getDuplicate(split[0]))
                        rootNode.setNext(new Node(split[0]));
                }
                else {


                    Node[] nodes = new Node[split.length];
                    for (int j = split.length - 1; j >= 0; j--) {
                        Node newLocation = new Node(split[j]);
                        nodes[j] = newLocation;
                    }
                    for (int j = 0; j < nodes.length - 1; j++) {
                        nodes[j + 1].prev = nodes[j];
                        nodes[j].setNext(nodes[j+1]);
                    }
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) {

        String[] directory = {
                "/",
                "/hello",
                "/hello/tmp",
                "/root",
                "/root/abcd",
                "/root/abcd/etc",
                "/root/abcd/hello"};
        String[] command = {
                "mkdir /root/tmp",
                "cp /hello /root/tmp",
                "rm /hello"};
        System.out.println(solution(directory, command));
    }


}
