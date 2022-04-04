package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * 문제 : https://leetcode.com/problems/min-stack/
 * 레벨 : Easy
 * 결과 : 해결(runtime 576ms faster than 5.00%, memory 51.1MB less than 5.07%)
 */
public class MinStack {
    static List<Integer> list;
    static int last;

    public MinStack() {

        list = new ArrayList<>();
        last = 0;

    }

    public void push(int val) {
        list.add(last, val);
        last = last + 1;
    }

    public void pop() {
        last = last - 1;
        list.remove(last);
    }

    public int top() {
        return list.get(last - 1);
    }

    public int getMin() {
        //Optional<List<Integer>> optionalInteger = Stream.of(list).sorted().findFirst();
        OptionalInt min = list.stream().mapToInt(n -> n).min();
        return min.getAsInt();
    }

}
