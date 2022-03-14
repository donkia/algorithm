package leetcode;


/**
 * 문제 : https://leetcode.com/problems/container-with-most-water/
 * 레벨 : Medium
 * 결과 : 해결(runtime 4ms faster than 72.43%, memory 81.4MB less than 21.42%)
 */


public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(start < end){

            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if(height[start] < height[end]){
                start = start + 1;
            }
            else if(height[start] > height[end]){
                end = end - 1;
            }
            else{
                if(height[start+1]<height[end-1]){
                    end = end - 1;
                }
                else
                    start = start + 1;
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }
}
