package com.epam.twosum;
import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int n = i + 1; n < nums.length; n++) {
                int number = nums[i] + nums[n];
                int[] twonums = new int[2];
                twonums[0] = i;
                twonums[1] = n;
                if (number == target) {
                    return twonums;
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,4,5,8,3};
        int target = 10;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}


