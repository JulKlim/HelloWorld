package com.epam.helloworld.reversedstr;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;


public class UpdatedReversedString {
    public static void main(String[] args) {
        try {
            File myString = new File("plants.txt");
            myString.createNewFile();
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("plants.txt"));
            myWriter.write("""
                    10.English ivy (Hedera helix)
                    9.Golden pothos (Epipremnum aureum 'Marble Queen')
                    8.Aloe vera (Aloe vera)
                    7.Bird of paradise (Strelitzia reginae)
                    6.Chinese evergreen (Aglaonema commutatum)
                    5.Rubber plant (Ficus elastica)
                    4.Pothos (Epipremnum aureum)
                    3.Snake plant (Sansevieria trifasciata)
                    2.Peace lily (Spathiphyllum wallisii)
                    1.Spider plant (Chlorophytum comosum)""");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.lines(Paths.get("plants.txt"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Original lines:");
        lines.forEach(System.out::println);

        Collections.reverse(lines);

        System.out.println("Reversed lines:");
        lines.forEach(System.out::println);

    }
}
