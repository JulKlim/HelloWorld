package com.epam.fizzbuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        int number = 10;
        if (number%3==0 && number%5==0) {
            System.out.println("Fizz-buzz");
        }
        else if (number%3==0) {
            System.out.println("Fizz");
        }
        else if (number%5==0) {
            System.out.println("Buzz");
        }
    }
}
