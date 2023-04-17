package com.epam.helloworld.ioexception;

import java.util.Scanner;

public class MyProgram {

    public static void main(String[] args) {


        Greenhouse greenhouse = new Greenhouse();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Add a new plant to the greenhouse");
            System.out.println("2 - Remove a plant from the greenhouse");
            System.out.println("3 - Find a plant in the greenhouse by name");
            System.out.println("4 - Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        // Add a new plant to the greenhouse
                        System.out.println("Enter plant name:");
                        String name = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter plant native region:");
                        String region = scanner.nextLine();
                        System.out.println("Enter plant special needs:");
                        String specialNeeds = scanner.nextLine();
                        System.out.println("Enter plant type:");
                        String type = scanner.nextLine();
                        Plant plant1 = PlantFactory.createPlant(name, region, specialNeeds, type);
                        greenhouse.addPlant(plant1);
                    }
                    case 2 -> {
                        // Remove a plant from the greenhouse
                        System.out.println("Enter the name of the plant to remove:");
                        String plantName = scanner.next();
                        boolean found = false;
                        for (Plant p : greenhouse.plants) {
                            if (p.getName().equals(plantName)) {
                                greenhouse.removePlant(p);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("The plant does not exist in the greenhouse");
                        }
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("Enter the name of the plant:");
                        String Name = scanner.next();
                        greenhouse.displayPlantsByName(Name);
                    }
                    case 4 -> {
                        System.out.println("Exiting the program...");
                        scanner.close();
                    }
                    default -> throw new InvalidOptionException("Invalid option. Please enter a valid option.");
                }
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }
}
