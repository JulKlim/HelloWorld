package com.epam.helloworld.poem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class UpdatedPoem {
    static class SortingByLength implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            File myPoem = new File("poem.txt");
            myPoem.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("poem.txt"));
            myWriter.write("""
                    Whose woods these are I think I know.
                    His house is in the village though;
                    He will not see me stopping here
                    To watch his woods fill up with snow.

                    My little horse must think it queer
                    To stop without a farmhouse near
                    Between the woods and frozen lake
                    The darkest evening of the year.

                    He gives his harness bells a shake
                    To ask if there is some mistake.
                    The only other sound’s the sweep
                    Of easy wind and downy flake.

                    The woods are lovely, dark and deep,
                    But I have promises to keep,
                    And miles to go before I sleep,
                    And miles to go before I sleep.""");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            List<String> poemLines = Files.lines(Paths.get("poem.txt"))
                    .sorted(new SortingByLength())
                    .toList();
            poemLines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("An error occurred while reading a file");
            e.printStackTrace();
        }

    }
}

