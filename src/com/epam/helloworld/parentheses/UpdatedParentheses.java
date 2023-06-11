package com.epam.helloworld.parentheses;


import java.util.List;

public class UpdatedParentheses {
    public static void main(String[] args) {
        String parentheses = "The (quick) brown (fox) jumps (over) the (lazy) dog's (tail).";

        List<Character> parChar = parentheses.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == '(' || c == ')')
                .toList();

        long count = parChar.stream()
                             .filter(c -> c == '(')
                             .count() - parChar.stream()
                             .filter(c -> c == ')')
                             .count();

        if (count == 0) {
            System.out.println("Parentheses are placed correctly");
        } else {
            System.out.println("Parentheses are placed incorrectly");
        }
    }
}
