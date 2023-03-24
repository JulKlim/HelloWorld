package com.epam.fibonacci;

public class Fibbonacci_n {
    public static void main(String[] args) {
        int number = 9;
        if (number == 0) {
            System.out.println(0);
        }
        if (number == 1) {
            System.out.println(1);
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= number; i++) {
            int c = a + b;
            a = b;
            b = c;
            if (i == number) {
                System.out.println(b);
            }

        }
    }
}
