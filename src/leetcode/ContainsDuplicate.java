package leetcode;

import java.util.HashSet;
/** 문제 : https://leetcode.com/problems/contains-duplicate/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 73.72%, memory less than 46.33%)
 * */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
            if(hs.size() != nums.length){
                return true;
            }
        }

        return false;


    }


}
