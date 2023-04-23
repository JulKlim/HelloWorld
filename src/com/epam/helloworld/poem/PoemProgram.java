package com.epam.helloworld.poem;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class PoemProgram {
    static class SortingByLength implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static void main(String[] args) {
        try {
            File myPoem = new File("poem.txt");
            myPoem.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("poem.txt"));
            myWriter.write("Whose woods these are I think I know.\n" +
                    "His house is in the village though;\n" +
                    "He will not see me stopping here\n" +
                    "To watch his woods fill up with snow.\n" +
                    "\n" +
                    "My little horse must think it queer\n" +
                    "To stop without a farmhouse near\n" +
                    "Between the woods and frozen lake\n" +
                    "The darkest evening of the year.\n" +
                    "\n" +
                    "He gives his harness bells a shake\n" +
                    "To ask if there is some mistake.\n" +
                    "The only other sound’s the sweep\n" +
                    "Of easy wind and downy flake.\n" +
                    "\n" +
                    "The woods are lovely, dark and deep,\n" +
                    "But I have promises to keep,\n" +
                    "And miles to go before I sleep,\n" +
                    "And miles to go before I sleep.");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> poemLines = new ArrayList<>();
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("poem.txt"));
            String line;
            while ((line = myReader.readLine()) != null) {
                poemLines.add(line);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading a file");
            e.printStackTrace();
        }
        poemLines.sort(new SortingByLength());

        for (String lineElement : poemLines) {
            System.out.println(lineElement);
        }

    }

}
