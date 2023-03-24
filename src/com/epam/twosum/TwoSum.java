package com.epam.twosum;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 5};
        int target = 9;
        for (int i = 0; i < nums.length; i++) {
            for (int n = i + 1; n < nums.length; n++) {
                int number = nums[i] + nums[n];
                int[] twonums = new int[2];
                twonums[0]=i;
                twonums[1]=n;
                if (number == target) {
                    System.out.println(java.util.Arrays.toString(twonums));
                }
            }
        }
    }
}


