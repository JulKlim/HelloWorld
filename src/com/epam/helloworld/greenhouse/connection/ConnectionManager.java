package com.epam.helloworld.greenhouse.connection;

import java.sql.SQLException;
import java.sql.*;

public class ConnectionManager {
    private static final String CONNECTION_STRING = "jdbc:sqlserver://EPTRANKW02F6\\MYDATABASE;encrypt=false;integratedSecurity=true;database=greenhouse";
    private static Connection conn;

    public static void registerDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver is not found");
            e.printStackTrace();
        }
        System.out.println("Driver is registered");
    }


    public static Connection create() {
        registerDriver();
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("We are connected");
        } catch (SQLException e) {
            System.err.println("Connection is not established");
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.getCause();
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection() {
        if (conn == null) {
            return create();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Disconnecting...");
    }

    //Selecting data from all 3 tables via join
    public static void selectPlantsGreenhousesGardeners() {
        String selectQuery = "SELECT * FROM plants " +
                "JOIN greenhouse ON plants.plant_id = greenhouse.plant_id " +
                "JOIN gardener ON greenhouse.greenhouse_id = gardener.greenhouse_id " +
                "ORDER BY plants.plant_name ASC";
        try (PreparedStatement stmt = getConnection().prepareStatement(selectQuery)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int plantId = rs.getInt("plant_id");
                String plantName = rs.getString("plant_name");
                String plantType = rs.getString("plant_type");
                int greenhouseId = rs.getInt("greenhouse_id");
                String location = rs.getString("location");
                int gardenerId = rs.getInt("gardener_id");
                String gardenerName = rs.getString("name");
                System.out.println("Plant ID = " + plantId + ", Plant name = " + plantName + ", Plant type = " + plantType +
                        ", Greenhouse ID = " + greenhouseId + ", Location = " + location + ", Gardener ID = " + gardenerId +
                        ", Gardener Name = " + gardenerName);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while selecting plants, greenhouses and gardeners.");
            e.printStackTrace();
        }
    }

    //Counting the number of records in gardener table
    public static void countGardeners() {
        String countQuery = "SELECT COUNT(*) AS gardener_count FROM gardener";
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(countQuery);
            while (rs.next()) {
                int count = rs.getInt("gardener_count");
                System.out.println("Number of gardeners = " + count);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while counting gardeners");
            e.printStackTrace();
        }
    }
}
