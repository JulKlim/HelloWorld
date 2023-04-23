package com.epam.helloworld.twosets;

import java.util.HashSet;
import java.util.Set;

public class TwoSets {
    public static void main(String[] args){
        Set<Integer> mySet1 = new HashSet<>();
        Set<Integer> mySet2 = new HashSet<>();

        //Adding values to mySet1
        mySet1.add(1);
        mySet1.add(3);
        mySet1.add(5);
        mySet1.add(4);
        mySet1.add(2);
        mySet1.add(9);

        //Adding values to mySet2
        mySet2.add(3);
        mySet2.add(14);
        mySet2.add(5);
        mySet2.add(45);
        mySet2.add(28);
        mySet2.add(9);

        Set<Integer> jointSet = new HashSet<>(mySet1);
        jointSet.addAll(mySet2);

        Set<Integer> intersectionSet = new HashSet<>(mySet1);
        intersectionSet.retainAll(mySet2);
        System.out.println("The joint set: " + jointSet + "\n"+ "The intersection between sets: " + intersectionSet);

    }
}
