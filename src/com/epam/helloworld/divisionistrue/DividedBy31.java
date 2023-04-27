package com.epam.helloworld.divisionistrue;

public class DividedBy31 {
    public static void main(String[] args) {
        Predicate myNumber = (int a) -> a % 31 == 0;
        System.out.println(myNumber.isDivided(31));
        System.out.println(myNumber.isDivided(8));


    }
}
