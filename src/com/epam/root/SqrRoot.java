package com.epam.root;

public class SqrRoot {
    public static void main(String[] args) {
        int x = 10;
        int n = x;
        while (n*n > x)
            n = (n + x / n) / 2;
        System.out.println(n);
    }
}

