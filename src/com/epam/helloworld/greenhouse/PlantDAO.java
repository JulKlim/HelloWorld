package com.epam.helloworld.greenhouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.helloworld.greenhouse.connection.ConnectionManager.getConnection;

public class PlantDAO implements GenericDAO<Plant, Integer> {
    private final Connection connection;

    public PlantDAO(Connection connection) {
        this.connection = connection;
    }

    //A script to insert values into plants table
    @Override
    public Plant create(Plant entity) {
        String addPlant = "INSERT INTO plants (plant_id, plant_name, plant_type) VALUES (?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(addPlant)) {
            stm.setInt(1, entity.getId());
            stm.setString(2, entity.getName());
            stm.setString(3, entity.getType());
            int rowsInserted = stm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Plant record is successfully inserted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while adding plants");
            e.printStackTrace();
        }
        return entity;
    }

    //Searching for all plants in the plants table
    @Override
    public List<Plant> findAll() throws SQLException {
        List<Plant> plants = new ArrayList<>();
        String searchQuery = "SELECT * FROM plants";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int plant_id = rs.getInt("plant_id");
                String plant_name = rs.getString("plant_name");
                String plant_type = rs.getString("plant_type");
                Plant plant = new Plant(plant_id, plant_name, plant_type);
                plants.add(plant);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching plants");
            e.printStackTrace();
        }
        return plants;
    }

    //Printing all plants in the plants table
    public void printAllPlants() {
        try {
            List<Plant> plants = findAll();
            for (Plant plant : plants) {
                System.out.println("Plant ID = " + plant.getId() + ", Plant name = " + plant.getName() + ", Plant type = " + plant.getType());
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while printing plants");
            e.printStackTrace();
        }
    }

    //A script to update a value in a record by specific parameter
    @Override
    public Plant update(Plant entity) {
        String updatePlantType = "UPDATE plants SET plant_type = ? WHERE plant_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(updatePlantType)) {
            stmt.setString(1, entity.getType());
            stmt.setInt(2, entity.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Plant type is successfully updated.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while updating plant type");
            e.printStackTrace();
        }
        return entity;
    }

    //Deleting a plant by id parameter
    @Override
    public void delete(Integer id) {
        String deletePlant = "DELETE FROM plants WHERE plant_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(deletePlant)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Plant with ID " + id + " is successfully deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while deleting plant");
            e.printStackTrace();
        }
    }

    //Searching using LIKE
    public static void searchPlantsByName(String plant_name) {
        String searchQuery = "SELECT * FROM plants WHERE plant_name LIKE ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            stmt.setString(1, "%" + plant_name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Plant ID = " + rs.getInt("plant_id") + ", Plant name = " + rs.getString("plant_name") + ", Plant type = " + rs.getString("plant_type"));
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching plants");
            e.printStackTrace();
        }
    }

    //Counting the number of records in plant table
    public static void countPlants() {
        String countQuery = "SELECT COUNT(*) AS plants_count FROM plants";
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(countQuery);
            while (rs.next()) {
                int count = rs.getInt("plants_count");
                System.out.println("Number of plants = " + count);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while counting plants");
            e.printStackTrace();
        }
    }

    //Aggregated function + GROUP BY
    public static void countPlantsByType() {
        String query = "SELECT plant_type, COUNT(*) AS count_plants FROM plants GROUP BY plant_type";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String plantType = rs.getString("plant_type");
                int count = rs.getInt("count_plants");
                System.out.println("Plant type: " + plantType + ", Total number = " + count);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while counting plants by type");
            e.printStackTrace();
        }
    }
}

