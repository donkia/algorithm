package leetcode;

/**
 * 문제 : https://leetcode.com/problems/merge-intervals/
 * 레벨 : Medium
 * 결과 : 해결(runtime 206ms faster than 5.07%, memory 55MB less than 43.55%)
 */
import java.util.*;

public class MergeIntervals {

    public static class Interval {
        private int start;
        private int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            int hashcode = 31;
            int result = 1;
            hashcode = hashcode * result + start + end;
            return hashcode;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Interval) {
                return ((Interval) obj).start == this.start && ((Interval) obj).end == this.end;
            }
            return false;
        }
    }

    public static int[][] merge(int[][] intervals) {
        LinkedHashSet<Interval> hashSet = new LinkedHashSet<>();


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1]) {
                    end = Math.max(intervals[j][1], intervals[i][1]);

                    intervals[j][0] = start;
                    intervals[j][1] = end;
                    intervals[i][0] = start;
                    intervals[i][1] = end;
                }
            }
            Interval interval = new Interval(start, end);
            hashSet.add(interval);
        }
        int[][] answer = new int[hashSet.size()][2];

        int idx = 0;
        Iterator<Interval> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Interval temp = iterator.next();
            answer[idx][0] = temp.start;
            answer[idx][1] = temp.end;
            idx++;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                /* {1, 3},
                 {2, 6},
                 {8, 10},
                 {15, 18}*/
                /*{1,4},
                {1,4}*/
                {1, 4},
                {2, 3}
        };

        System.out.println(merge(intervals));
    }
}
