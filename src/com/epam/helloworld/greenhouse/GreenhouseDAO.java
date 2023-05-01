package com.epam.helloworld.greenhouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.helloworld.greenhouse.connection.ConnectionManager.getConnection;

public class GreenhouseDAO implements GenericDAO<Greenhouse, Integer> {
    private final Connection connection;

    public GreenhouseDAO(Connection connection) {
        this.connection = connection;
    }


    //A script to insert values into greenhouse table
    @Override
    public Greenhouse create(Greenhouse entity) {
        String addGreenhouse = "INSERT INTO greenhouse (greenhouse_id, location, plant_id) VALUES (?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(addGreenhouse)) {
            stm.setInt(1, entity.getId());
            stm.setString(2, entity.getLocation());
            stm.setInt(3, entity.getPlant());
            int rowsInserted = stm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Greenhouse record is successfully inserted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while adding greenhouse");
            e.printStackTrace();
        }
        return entity;
    }

    //Searching for all greenhouses in the greenhouse table
    @Override
    public List<Greenhouse> findAll() throws SQLException {
        List<Greenhouse> greenhouses = new ArrayList<>();
        String searchQuery = "SELECT * FROM greenhouse";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int greenhouse_id = rs.getInt("greenhouse_id");
                String location = rs.getString("location");
                int plant_id = rs.getInt("plant_id");
                Greenhouse greenhouse = new Greenhouse(greenhouse_id, location, plant_id);
                greenhouses.add(greenhouse);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching greenhouses");
            e.printStackTrace();
        }
        return greenhouses;
    }

    //Printing all greenhouses in the greenhouse table
    public void printAllGreenhouses() {
        try {
            List<Greenhouse> greenhouses = findAll();
            for (Greenhouse greenhouse : greenhouses) {
                System.out.println("Greenhouse ID = " + greenhouse.getId() + ", Location = " + greenhouse.getLocation() + ", Plant ID = " + greenhouse.getPlant());
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while printing greenhouses");
            e.printStackTrace();
        }
    }

    //A script to update a value in a record by specific parameter
    @Override
    public Greenhouse update(Greenhouse entity) {
        String updateGreenhousePlant = "UPDATE greenhouse SET plant_id = ? WHERE greenhouse_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(updateGreenhousePlant)) {
            stmt.setInt(1, entity.getPlant());
            stmt.setInt(2, entity.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Greenhouse plant is successfully updated.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while updating greenhouse plant");
            e.printStackTrace();
        }
        return entity;
    }

    //Deleting a greenhouse by id parameter
    @Override
    public void delete(Integer id) {
        String deleteGreenhouse = "DELETE FROM greenhouse WHERE greenhouse_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(deleteGreenhouse)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Greenhouse with ID " + id + " is successfully deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while deleting greenhouse");
            e.printStackTrace();
        }
    }

    //Search using BETWEEN
    public static void searchGreenhousesByLocation(String start, String end) {
        String searchQuery = "SELECT * FROM greenhouse WHERE location BETWEEN ? AND ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            stmt.setString(1, start);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Greenhouse ID = " + rs.getInt("greenhouse_id") + ", Greenhouse location = " + rs.getString("location") + ", Plant ID = " + rs.getInt("plant_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching greenhouses");
            e.printStackTrace();
        }
    }

    //Counting the number of records in greenhouse table
    public static void countGreenhouses() {
        String countQuery = "SELECT COUNT(*) AS greenhouse_count FROM greenhouse";
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(countQuery);
            while (rs.next()) {
                int count = rs.getInt("greenhouse_count");
                System.out.println("Number of greenhouses = " + count);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while counting greenhouses");
            e.printStackTrace();
        }
    }

}

