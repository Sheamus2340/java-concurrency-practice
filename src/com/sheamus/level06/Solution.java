package com.sheamus.level06;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {

            for(int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target && i != j) {
                    return new int[]{i,j};
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] result = solution.twoSum(nums,target);
        System.out.println(result[0] + "," + result[1]);
    }

}
