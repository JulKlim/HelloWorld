package com.epam.helloworld.greenhouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.helloworld.greenhouse.connection.ConnectionManager.getConnection;

public class GardenerDAO implements GenericDAO<Gardener, Integer> {
    private final Connection connection;

    public GardenerDAO(Connection connection) {
        this.connection = connection;
    }

    //A script to insert values into gardener table
    @Override
    public Gardener create(Gardener entity) {
        String addGardener = "INSERT INTO gardener (gardener_id, name, greenhouse_id) VALUES (?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(addGardener)) {
            stm.setInt(1, entity.getId());
            stm.setString(2, entity.getName());
            stm.setInt(3, entity.getGreenhouse());
            int rowsInserted = stm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Gardener record is successfully inserted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while adding gardener");
            e.printStackTrace();
        }
        return entity;
    }

    //Searching for all gardeners in the gardener table
    @Override
    public List<Gardener> findAll() throws SQLException {
        List<Gardener> gardeners = new ArrayList<>();
        String searchQuery = "SELECT * FROM gardener";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int gardener_id = rs.getInt("gardener_id");
                String name = rs.getString("name");
                int greenhouse_id = rs.getInt("greenhouse_id");
                Gardener gardener = new Gardener(gardener_id, name, greenhouse_id);
                gardeners.add(gardener);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching gardeners");
            e.printStackTrace();
        }
        return gardeners;
    }

    //Printing all gardeners in the gardener table
    public void printAllGardeners() {
        try {
            List<Gardener> gardeners = findAll();
            for (Gardener gardener : gardeners) {
                System.out.println("Gardener ID = " + gardener.getId() + ", Name = " + gardener.getName() + ", Greenhouse ID = " + gardener.getGreenhouse());
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while printing gardeners");
            e.printStackTrace();
        }
    }

    //A script to update a value in a record by specific parameter
    @Override
    public Gardener update(Gardener entity) {
        String updateGardenerName = "UPDATE gardener SET name = ? WHERE gardener_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(updateGardenerName)) {
            stmt.setString(1, entity.getName());
            stmt.setInt(2, entity.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Gardener name is successfully updated.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while updating gardener name");
            e.printStackTrace();
        }
        return entity;
    }

    //Deleting a gardener by id parameter
    @Override
    public void delete(Integer id) {
        String deleteGardener = "DELETE FROM gardener WHERE gardener_id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(deleteGardener)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Gardener with ID " + id + " is successfully deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while deleting gardener");
            e.printStackTrace();
        }
    }

    //Deleting all records from the table
    public void deleteAllGardeners() {
        String deleteGardeners = "DELETE FROM gardener";
        try (PreparedStatement stmt = getConnection().prepareStatement(deleteGardeners)) {
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("All gardeners are successfully deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while deleting gardeners");
            e.printStackTrace();
        }
    }

    //Search using IN
    public static void searchGardenersByName(String... names) {
        String searchQuery = "SELECT * FROM gardener WHERE name IN (";
        for (int i = 0; i < names.length; i++) {
            searchQuery += "?";
            if (i != names.length - 1) {
                searchQuery += ", ";
            }
        }
        searchQuery += ")";
        try (PreparedStatement stmt = getConnection().prepareStatement(searchQuery)) {
            for (int i = 0; i < names.length; i++) {
                stmt.setString(i + 1, names[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Gardener ID = " + rs.getInt("gardener_id") + ", Name = " + rs.getString("name") + ", Greenhouse ID = " + rs.getInt("greenhouse_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while searching gardeners");
            e.printStackTrace();
        }
    }

}