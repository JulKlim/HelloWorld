package com.epam.helloworld.parentheses;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesProgram {
    public static void main(String[] args) {
        String parentheses = "The (quick) brown (fox) jumps (over) the (lazy)) dog's (tail).";
        List<Character> parChar = new ArrayList<Character>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '(' || c == ')') {
                parChar.add(c);
            }
        }
        int count = 0;
        for (Character c : parChar) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
        }
        if (count == 0) {
            System.out.println("Parentheses are placed correctly");
        } else {
            System.out.println("Parentheses are placed incorrectly");
        }
    }
}
