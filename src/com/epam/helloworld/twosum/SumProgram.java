package com.epam.helloworld.twosum;

public class SumProgram {
    public static void main(String[] args) {
        SumFunction sum1 = Integer::sum;
        System.out.println(sum1.sum(5, 10));
    }
}
