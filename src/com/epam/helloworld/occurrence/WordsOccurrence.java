package com.epam.helloworld.occurrence;

import java.io.*;
import java.util.*;

public class WordsOccurrence {
    public static void main(String[] args) {
        try {
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
            BufferedReader myReader = new BufferedReader(new FileReader("A Day at the Park.txt"));
            String lines;
            HashMap<String, Integer> wordsOccurrence = new HashMap<>();
            while ((lines = myReader.readLine()) != null) {
                String[] words = lines.split("\\s+");
                for (String word : words) {
                    if (wordsOccurrence.containsKey(word)) {
                        wordsOccurrence.put(word, wordsOccurrence.get(word) + 1);
                    } else {
                        wordsOccurrence.put(word, 1);
                    }
                }
            }
            myReader.close();

            for (Map.Entry<String, Integer> entry : wordsOccurrence.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.print("An error occurred");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
            e.printStackTrace();
        }
    }
}
