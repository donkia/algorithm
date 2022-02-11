package leetcode;

/** 문제 : https://leetcode.com/problems/house-robber-ii/
 *  레벨 : Medium
 *  결과 : 해결(runtime 1ms faster than 26.68%, memory 42.3MB less than 6.15%)
 * */

public class HouseRobber2 {

    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        else if(nums.length == 3){
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        
        // nums[0] 을 제거한 배열에서 최대값 구하기
        int[] visit = new int[nums.length-1];
        int[] temp = new int[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            temp[i - 1] = nums[i];
        }

        visit[0] = temp[0];
        visit[1] = temp[1];
        visit[2] = temp[0] + temp[2];

        for(int i = 3; i < temp.length; i++){
            visit[i] = Math.max(visit[i - 3] + temp[i], visit[i - 2] + temp[i]);
        }
        int max1 = 0;
        for(int i = 0; i < temp.length; i++){
            if(max1 < visit[i]){
                max1 = visit[i];
            }
        }

        
        // nums[last]를 제거한 배열에서 최대값 구하기
        for(int i = 0; i < nums.length-1; i++){
            temp[i] = nums[i];
        }

        visit[0] = temp[0];
        visit[1] = temp[1];
        visit[2] = temp[0] + temp[2];

        for(int i = 3; i < temp.length; i++){
            visit[i] = Math.max(visit[i - 3] + temp[i], visit[i - 2] + temp[i]);
        }
        int max2 = 0;
        for(int i = 0; i < temp.length; i++){
            if(max2 < visit[i]){
                max2 = visit[i];
            }
        }

        
        // 최대값(max1, max2) 중 큰 값 리턴
        if(max1 < max2)
            return max2;
        else
            return max1;


    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 3, 4, 9};

        System.out.println(rob(nums));
    }

}
