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

    private static String countryName;

    public static void main(String[] args)
    {

        // Create new db object from class
        DbConnection dbc = new DbConnection();

        // Connect to database
        dbc.connect();

        // Gets connection value
        Connection con = dbc.getConnection();

        // Report 1:
        // Get population of the world
        Long totalPopulation = getWorldPopulation(con);
        System.out.println("World Population: " + totalPopulation);

        // Report 2:
        // Get population of given continent
        // Set continent to get population of
        // 'Asia','Europe','North America','Africa','Oceania','Antarctica','South America'
        String continent = "Europe";
        Long continentPopulation = getPopulationOfContinent(con, continent);
        System.out.println("Population of " + continent + " is " + continentPopulation);

        // Report 3:
        // Get population of given region
        // Set region to get population of
        String region = "Southern Europe";
        Long regionPopulation = getPopulationOfRegion(con, region);
        System.out.println("Population of " + region + " is " + regionPopulation);

        // Report 4:
        // Get the population of given country
        // Set the country code
        String code = "GBR";
        Long countryPopulation = getCountryPopulation(con, code);
        System.out.println("The population of " + countryName + " is " + countryPopulation);

        // Report 5:
        // Get the population of given district
        // Set the district
        String district = "England";
        Long districtPopulation = getDistrictPopulation(con, district);
        System.out.println("The population of " + district + " is " + districtPopulation);

        // Disconnect from database
        dbc.disconnect();

    }

    /**
     * Method to return the population of the world
     * @param con Holds the connection to the SQL server
     * @return The population of the world or null if there is an error
     */
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

    /**
     * Method to return the population of a given continent
     * @param con Holds the connection to the SQL server
     * @param continent Contains the continent to get the population for
     * @return The population of the continent or null if there is an error
     */
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
            System.out.println("Failed to calculate the population of the continent " + continent);
            return null;
        }
    }

    /**
     * Method to return the population of a specified region
     * @param con Holds the connection to the SQL server
     * @param region Contains the region to get the population for
     * @return The population of the region or null if there is an error
     */
    private static Long getPopulationOfRegion(Connection con, String region) {
        try {
            // Create SQL statement
            Statement regionStatement = con.createStatement();
            // Create string for SQL statement
            String regionPopulation = "SELECT SUM(population) as regionPopulation " +
                    "FROM country " +
                    "WHERE region = '" + region + "';";
            // Execute SQL statement
            ResultSet rset = regionStatement.executeQuery(regionPopulation);
            // Return population of continent if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("regionPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the region " + region);
            return null;
        }
    }

    /**
     * Method to return the population for a specified country
     * @param con Holds the connection to the SQL server
     * @param code Contains the unique country code used to retrieve the correct population
     * @return Country name & population
     */
    private static Long getCountryPopulation(Connection con, String code) {
        try {
            // Create SQL statement
            Statement countryPopulationStatement = con.createStatement();
            // Create string for SQL statement
            String countryPopulation = "SELECT name, population " +
                    "FROM country " +
                    "WHERE code = '" + code + "';";
            // Execute SQL statement
            ResultSet rset = countryPopulationStatement.executeQuery(countryPopulation);
            // Return population of specified country + country name
            // Check something is returned
            if(rset.next()) {
                countryName = rset.getString("name");
                return rset.getLong("population");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the country with the code " + code);
            return null;
        }
    }

    /**
     * Method to return the population of a specified district
     * @param con Holds the connection to the SQL server
     * @param district Contains the district to find the population for
     * @return Population of given district
     */
    private static Long getDistrictPopulation(Connection con, String district) {
        try {
            // Create SQL statement
            Statement districtPopulationStatement = con.createStatement();
            // Create string for SQL statement
            String districtPopulation = "SELECT SUM(population) as districtPopulation " +
                    "FROM city " +
                    "WHERE district = '" + district + "';";
            // Execute SQL statement
            ResultSet rset = districtPopulationStatement.executeQuery(districtPopulation);
            // Return population of specified district
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("districtPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the district.");
            return null;
        }
    }
}