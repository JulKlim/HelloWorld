package com.epam.helloworld.reversedstr;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.util.Collections;


public class ReversedString {
    public static void main(String[] args) {
        try {
            File myString = new File("plants.txt");
            myString.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("plants.txt"));
            myWriter.write("10.English ivy (Hedera helix)\n" +
                    "9.Golden pothos (Epipremnum aureum 'Marble Queen')\n" +
                    "8.Aloe vera (Aloe vera)\n" +
                    "7.Bird of paradise (Strelitzia reginae)\n" +
                    "6.Chinese evergreen (Aglaonema commutatum)\n" +
                    "5.Rubber plant (Ficus elastica)\n" +
                    "4.Pothos (Epipremnum aureum)\n" +
                    "3.Snake plant (Sansevieria trifasciata)\n" +
                    "2.Peace lily (Spathiphyllum wallisii)\n" +
                    "1.Spider plant (Chlorophytum comosum)");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("plants.txt"));
            String data;
            while ((data = myReader.readLine()) != null) {
                lines.add(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Original lines:");
        for (String line : lines) {
            System.out.println(line);
        }

        // Reverse the order of the lines
        Collections.reverse(lines);

        System.out.println("Reversed lines:");
        for (String line : lines) {
            System.out.println(line);
        }

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("plants.txt"));
            for (String line : lines) {
                myWriter.write(line);
                myWriter.newLine();
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
