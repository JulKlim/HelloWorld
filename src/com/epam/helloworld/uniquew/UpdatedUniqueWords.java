package com.epam.helloworld.uniquew;

import java.io.*;
import java.util.*;

public class UpdatedUniqueWords {
    public static void main(String[] args) {
        try {
            File myText = new File("randomText.txt");
            myText.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("randomText.txt"));
            myWriter.write("The quick brown fox jumps over the lazy dog. A quick red fox jumps over a lazy brown dog. The brown dog yawns as the red fox jumps over it. Foxes are quick and dogs are lazy, that is just how it is.");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Set<String> mySet = new HashSet<>();
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("randomText.txt"));
            myReader.lines()
                    .flatMap(line -> Arrays.stream(line.split("[^a-zA-Z]+")))
                    .map(String::toLowerCase)
                    .forEach(mySet::add);
        } catch (IOException e) {
            System.out.println("An error occurred while reading a file");
            e.printStackTrace();
        }
        System.out.println(mySet);
    }
}
