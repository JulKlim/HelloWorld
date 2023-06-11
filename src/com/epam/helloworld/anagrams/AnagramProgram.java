package com.epam.helloworld.anagrams;

import java.util.Arrays;

public class AnagramProgram {
    public static void main(String[] args) {
        CheckAnagram check1 = (String s1, String s2) -> {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();

            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);

            return Arrays.equals(s1Arr, s2Arr);
        };
        System.out.println(check1.isAnagram("listen", "silent"));
        System.out.println(check1.isAnagram("apple", "apricot"));
        System.out.println(check1.isAnagram("thing", "night"));
    }
}
