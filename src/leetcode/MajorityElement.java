package leetcode;

import java.util.HashMap;

/**
 * 문제 : https://leetcode.com/problems/majority-element/
 * 레벨 : Easy
 * 결과 : 해결(runtime 15ms faster than 22.46%, memory 55.1MB less than 42.06%)
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

        for(int t : nums) {
            if(hs.containsKey(t)) {
                int n = hs.get(t);
                hs.put(t, n+1);

            }
            else {

                hs.put(t, 1);

            }
        }

        int length = nums.length / 2;

        for(int t : hs.keySet()) {
            if(hs.get(t) > length) {
                return t;
            }

        }


        //System.out.println(hs);



        return 1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
    }
}
