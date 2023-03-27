package com.epam.palindrome;

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder reversedS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            reversedS.insert(0, cha);
        }
        if (reversedS.toString().equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean a = solution.isPalindrome(121);
        System.out.println(a);
    }
}

