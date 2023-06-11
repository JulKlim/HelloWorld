package com.epam.helloworld.occurrence;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class UpdatedWordsOccurrence {
    public static void main(String[] args) {
        try {
            // Create and write to the text file
            File myText = new File("A Day at the Park.txt");
            myText.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("A Day at the Park.txt"));
            myWriter.write("It was a beautiful day at the park. Children were playing on the swings and slides, while parents sat on benches and chatted with each other. A group of teenagers were playing soccer on the field, while a man and his dog played catch nearby. The sun was shining and the birds were singing, creating a peaceful atmosphere. As the day went on, more and more people arrived at the park, enjoying the warm weather and each other's company. Eventually, the park started to empty out as the sun began to set, but the memories of the day would last forever.");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Map<String, Integer> wordsOccurrence = Files.lines(Paths.get("A Day at the Park.txt"))
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(word -> new AbstractMap.SimpleEntry<>(word.replaceAll("[^a-zA-Z]", "").toLowerCase(), 1))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));

            wordsOccurrence.forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
            e.printStackTrace();
        }
    }
}
