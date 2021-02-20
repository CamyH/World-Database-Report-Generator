package com.napier.sem;

import java.sql.*;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/02/2021
 * Purpose of program: To run SQL queries to satisfy the given requirements
 * Last modified by: Cameron
 */

public class App
{

    public static void main(String[] args)
    {

        // Create new db object from class
        DbConnection dbc = new DbConnection();

        // Connect to database
        dbc.connect();

        // Gets connection value
        Connection con = dbc.getConnection();

        // Get population of the world
        Long totalPopulation = getWorldPopulation(con);
        System.out.println("World Population: " + totalPopulation);

        // Get population of given continent
        // Set continent to get population of
        String continent = "Europe";
        Long continentPopulation = getPopulationOfContinent(con, continent);
        System.out.println("Population of " + continent + " is " + continentPopulation);

        // Disconnect from database
        dbc.disconnect();

    }

    private static Long getWorldPopulation(Connection con) {
        try {
            // Create SQL statement
            Statement populationStatement = con.createStatement();
            // Create string for SQL statement
            String worldPopulation = "SELECT SUM(population) as worldPopulation " +
                    "FROM country;";
            // Execute SQL statement
            ResultSet rset = populationStatement.executeQuery(worldPopulation);
            // Return world population if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("worldPopulation");
            } else
                return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the world.");
            return null;
        }
    }

    private static Long getPopulationOfContinent(Connection con, String continent) {
        try {
            // Create SQL statement
            Statement continentStatement = con.createStatement();
            // Create string for SQL statement
            String continentPopulation = "SELECT SUM(population) as continentPopulation " +
                    "FROM country " +
                    "WHERE continent = '" + continent + "';";
            // Execute SQL statement
            ResultSet rset = continentStatement.executeQuery(continentPopulation);
            // Return population of continent if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("continentPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the continent.");
            return null;
        }
    }
}