package com.epam.helloworld.greenhouse;

import com.epam.helloworld.greenhouse.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

import static com.epam.helloworld.greenhouse.PlantDAO.countPlants;
import static com.epam.helloworld.greenhouse.PlantDAO.searchPlantsByName;
import static com.epam.helloworld.greenhouse.connection.ConnectionManager.*;

public class MyProgram {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.create();

        PlantDAO plantDAO = new PlantDAO(conn);
        //Insert new plant records into the database
        plantDAO.create(new Plant(7, "Sunflower", "Flower"));
        plantDAO.create(new Plant(8, "Thyme", "Herb"));
        plantDAO.create(new Plant(9, "Eggplant", "Vegetable"));
        plantDAO.create(new Plant(10, "Daisy", "Flower"));
        plantDAO.create(new Plant(11, "Rosemary", "Herb"));
        plantDAO.create(new Plant(12, "Zucchini", "Vegetable"));

        GreenhouseDAO greenhouseDAO = new GreenhouseDAO(conn);
        //Insert new greenhouse records into the database
        greenhouseDAO.create(new Greenhouse(7, "New York City", 7));
        greenhouseDAO.create(new Greenhouse(8, "Los Angeles", 8));
        greenhouseDAO.create(new Greenhouse(9, "Chicago", 9));
        greenhouseDAO.create(new Greenhouse(10, "Houston", 10));
        greenhouseDAO.create(new Greenhouse(11, "Miami", 11));
        greenhouseDAO.create(new Greenhouse(12, "Seattle", 12));

        GardenerDAO gardenerDAO = new GardenerDAO(conn);
        //Inserting values into gardener table
        gardenerDAO.create(new Gardener(7, "John Doe", 7));
        gardenerDAO.create(new Gardener(8, "Jane Smith", 8));
        gardenerDAO.create(new Gardener(9, "David Lee", 9));
        gardenerDAO.create(new Gardener(10, "Sarah Kim", 10));
        gardenerDAO.create(new Gardener(11, "Michael Brown", 10));
        gardenerDAO.create(new Gardener(12, "Laura Davis", 7));


        //Search greenhouse using BETWEEN
        GreenhouseDAO.searchGreenhousesByLocation("A", "M");
        //Search plant by name using LIKE
        searchPlantsByName("owe");
        //Search gardeners using IN
        GardenerDAO.searchGardenersByName("John Doe", "David Lee");

        //Count the number of plants in plants table
        countPlants();
        PlantDAO.countPlantsByType();
        //Count all records in greenhouse table
        GreenhouseDAO.countGreenhouses();
        //Count all records in gardener table
        countGardeners();

        //Display all plant records in the database
        plantDAO.printAllPlants();
        //Select data from 3 tables using JOIN
        selectPlantsGreenhousesGardeners();

        // Delete method to delete a specific plant record by ID
        plantDAO.delete(2);
        //Deleting all records from gardener table
        //gardenerDAO.deleteAllGardeners();

        //Updating a record in plants table
        Plant existingPlant = new Plant(7, "Sunflower", "Herb and Flower");
        plantDAO.update(existingPlant);

        plantDAO.printAllPlants();


        closeConnection(conn);

    }
}
