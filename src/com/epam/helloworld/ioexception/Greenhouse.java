package com.epam.helloworld.ioexception;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Greenhouse {
    public List<Plant> plants;
    private static final String FILE_NAME = "plants.txt";

    public Greenhouse() {
        plants = readPlantsFromFile();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
        writePlantsToFile(plants);
        displayPlantsByType();
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
        writePlantsToFile(plants);
        displayPlantsByType();
    }

    public static void writePlantsToFile(List<Plant> plants) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Plant plant : plants) {
                writer.write(plant.getName() + "," + plant.getRegion() + "," + plant.getSpecialNeeds() + "," + plant.getType());
                writer.newLine();
            }
            System.out.println("Writing plants to file: " + FILE_NAME);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred during writing to the file: " + e.getMessage());
        }
    }

    public static List<Plant> readPlantsFromFile() {
        List<Plant> plants = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String region = parts[1];
                String specialNeeds = parts[2];
                String type = parts[3];
                Plant plant = PlantFactory.createPlant(name, region, specialNeeds, type);
                plants.add(plant);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred during reading from file: " + e.getMessage());
        }
        return plants;
    }

        public void displayPlantsByType() {
            System.out.println("Plants in the greenhouse sorted by type:");
            List<Plant> sortedPlants = plants.stream()
                    .sorted(Comparator.comparing(Plant::getType))
                    .toList();

            for (Plant plant : sortedPlants) {
                System.out.println(plant.getInfoAboutPlant());
            }
        }
    public void displayPlantsByName(String name) {
        List<Plant> sortedPlants = readPlantsFromFile().stream()
                .sorted(Comparator.comparing(Plant::getRegion))
                .toList();

            for (Plant plant: plants) {
                if (plant.getName().equals(name)) {
                    System.out.println(plant.getInfoAboutPlant());
                    return;
                }
            }
            System.out.println("No plant with the name '" + name + "' found in the greenhouse.");

    }
}
