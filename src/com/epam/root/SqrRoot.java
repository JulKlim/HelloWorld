package com.epam.root;

public class SqrRoot {
    public static void main(String[] args) {
        int x = 16;
        int n = x;
        while (n*n > x)
            n = (n + x / n) / 2;
        System.out.println(n);
    }
}

