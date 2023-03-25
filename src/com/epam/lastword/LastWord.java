package com.epam.lastword;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] sArray;
        sArray = s.split(" ");
        for (int i=0;i<=sArray.length;i++) {
            if (i==sArray.length-1){
                String str = sArray[i];
                return str.length();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Spring is coming in a few months";
        int result = solution.lengthOfLastWord(s);
        System.out.println(result);
    }
}
