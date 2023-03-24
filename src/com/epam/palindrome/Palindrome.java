package com.epam.palindrome;

import java.util.Scanner;

public class Palindrome {
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         System.out.println("Enter the word or number");
         String str = scan.nextLine();


         StringBuilder reversedString = new StringBuilder();
         for (int i = 0; i < str.length(); i++) {
             char cha;
             cha = str.charAt(i);
             reversedString.insert(0, cha);
         }
         if (reversedString.toString().equals(str)) {
             System.out.println("True");
         } else {
             System.out.println("False");
         }


     }
}
