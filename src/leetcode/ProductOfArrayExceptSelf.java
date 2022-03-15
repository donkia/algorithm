package leetcode;

/**
 * 문제 : https://leetcode.com/problems/product-of-array-except-self/
 * 레벨 : Medium
 * 결과 : 참고 후 해결(runtime 2ms faster than 80.79%, memory 58.1MB less than 19.30%)
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int acc = 1;
        for(int i = nums.length -2 ; i>=0 ; i--){
            acc = acc * nums[i + 1];
            answer[i] *= acc;
        }

        return answer;


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));

    }

}
