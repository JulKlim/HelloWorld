package com.epam.helloworld.anagrams;

@FunctionalInterface
public interface CheckAnagram {
    boolean isAnagram(String s1, String s2);
}
