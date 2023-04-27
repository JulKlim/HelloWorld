package com.epam.helloworld.twosets;

import java.util.HashSet;
import java.util.Set;

public class UpdatedTwoSets {
    public static void main(String[] args) {
        Set<Integer> mySet1 = Set.of(1, 3, 5, 4, 2, 9);
        Set<Integer> mySet2 = Set.of(3, 14, 5, 45, 28, 9);


        Set<Integer> jointSet = new HashSet<>(mySet1);
        jointSet.addAll(mySet2);

        Set<Integer> intersectionSet = new HashSet<>();
        mySet1.stream()
                .filter(mySet2::contains)
                .forEach(intersectionSet::add);
        System.out.println("The joint set: " + jointSet + "\n" + "The intersection between sets: " + intersectionSet);

    }
}
