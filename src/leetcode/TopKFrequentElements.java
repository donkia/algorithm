package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 문제 : https://leetcode.com/problems/top-k-frequent-elements/
 * 레벨 : Medium
 * 결과 : 해결(runtime 16ms faster than 62.33%, memory 51.4MB less than 8.94%)
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] answer = new int[k];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (hashMap.containsKey(num)) {
                int cnt = hashMap.get(num);
                hashMap.put(num, cnt + 1);
            } else {
                hashMap.put(num, 1);
            }

        }

        int[][] arr = new int[hashMap.size()][2];
        int idx = 0;
        for (Integer num : hashMap.keySet()) {
            arr[idx][0] = hashMap.get(num);
            arr[idx][1] = num;
            idx++;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        idx = 0;
        for (int i = 0; i < k; i++) {
            answer[idx++] = arr[i][1];
        }


        return answer;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
