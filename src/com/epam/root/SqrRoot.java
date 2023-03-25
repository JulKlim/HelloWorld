package com.epam.root;

class Solution {
    public int mySqrt(int x) {
        int n = x;
        while (n * n > x) {
            n = (n + x / n) / 2;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 8;
        int result = solution.mySqrt(x);
        System.out.println(result);
    }
}

