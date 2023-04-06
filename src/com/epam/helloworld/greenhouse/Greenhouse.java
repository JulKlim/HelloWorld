package com.epam.helloworld.greenhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
public class Greenhouse {
    public List<Plants> plants;

    public Greenhouse() {
        plants = new ArrayList<>();
    }

    public void buyPlant(Plants plant) {
        plants.add(plant);
        System.out.println("The plant is bought");
    }

    public void removePlant(Plants plant) {
        plants.remove(plant);
        System.out.println("The plant is removed");
    }

    public void displayPlantsByType() {
        System.out.println("Plants in the greenhouse sorted by type:");
        List<Plants> sortedPlants = plants.stream()
                .sorted(Comparator.comparing(Plants::getType))
                .collect(Collectors.toList());

        for (Plants plant : sortedPlants) {
            System.out.println(plant.getInfoAboutPlant());
        }
    }

    public void displayPlantsByRegion() {
        System.out.println("Plants in the greenhouse sorted by native region:");
        List<Plants> sortedPlants = plants.stream()
                .sorted(Comparator.comparing(Plants::getRegion))
                .collect(Collectors.toList());

        for (Plants plant : sortedPlants) {
            System.out.println(plant.getInfoAboutPlant());
        }
    }

    public void updatePlantSpecialNeeds(Plants plant, String newSpecialNeeds) {
        plant.updateInfoAboutPlant(newSpecialNeeds);
    }

    public void water() {
        System.out.println("The plants are watered");
    }

    public void changeTemperature() {
        System.out.println("The temperature is changed");
    }
}


