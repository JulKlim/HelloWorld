package com.epam.helloworld.greenhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

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
                .toList();

        for (Plants plant : sortedPlants) {
            System.out.println(plant.getInfoAboutPlant());
        }
    }

    public void displayPlantsByRegion() {
        System.out.println("Plants in the greenhouse sorted by native region:");
        List<Plants> sortedPlants = plants.stream()
                .sorted(Comparator.comparing(Plants::getRegion))
                .toList();

        for (Plants plant : sortedPlants) {
            System.out.println(plant.getInfoAboutPlant());
        }
    }

    public void water() {
        System.out.println("The plants are watered");
    }


    public static class TemperatureController {        //Nested class
        static int temperature;

        TemperatureController(int temperature) {
            TemperatureController.temperature = temperature;
        }

        public String getTemperatureInfo() {
            return "Temperature: " + temperature + "degrees";
        }

        public static void checkTemperature() {
            if (temperature <= 10) {
                int increasedTemperature = temperature + 5;
                System.out.println("The temperature is increased. Current temperature is " + increasedTemperature + " degrees");
            } else if (temperature >= 25) {
                int decreasedTemperature = temperature - 5;
                System.out.println("The temperature is decreased. Current temperature is " + decreasedTemperature + " degrees");
            } else {
                System.out.println("The temperature is normal. Current temperature is " + temperature + " degrees");
            }
        }
    }

}


