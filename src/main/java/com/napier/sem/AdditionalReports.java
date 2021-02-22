package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Author: Cameron
 * Date last modified: 21/02/2021
 * Purpose of class: Contains 6 methods to return populations of the world, a city, a district, a region, a continent & a country.
 */

public class AdditionalReports {

    /**
     * Method to return the population of the world
     * @param con Holds the connection to the SQL server
     * @return The population of the world or null if there is an error
     */
    public static Long getWorldPopulation(Connection con) {
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
    public static Long getPopulationOfContinent(Connection con, String continent) {
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
    public static Long getPopulationOfRegion(Connection con, String region) {
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
     * @return The population of a country or null if there is an error
     */
    public static Long getCountryPopulation(Connection con, String code) {
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
     * @param district Contains the district to get the population for
     * @return The population of a given district or null if there is an error
     */
    public static Long getDistrictPopulation(Connection con, String district) {
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

    /**
     * Method to return the population of a specified city
     * @param con Holds the connection to the SQL server
     * @param cityName Contains the city to get the population for
     * @return The population of a given city or null if there is an error
     */
    public static Long getCityPopulation(Connection con, String cityName) {
        try {
            // Create SQL statement
            Statement cityPopulationStatement = con.createStatement();
            // Create string for SQL statement
            String cityPopulation = "SELECT population " +
                    "FROM city " +
                    "WHERE name = '" + cityName + "';";
            // Execute SQL statement
            ResultSet rset = cityPopulationStatement.executeQuery(cityPopulation);
            // Return population of specified city
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("population");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of " + cityName);
            return null;
        }
    }

    /**
     * Method to return a list of population data for each continent
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each continent in an ArrayList,
     * or null if there is an error.
     */
    public static ArrayList<PopulationData> getPopulationDataContinent(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.continent, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.continent; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population of continents
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.identifier = rset.getString("country.continent");
                popData.population = getPopulationOfContinent(con, popData.identifier);
                popData.populationInCities = rset.getLong("citiesPopulation");
                popData.populationNotInCities = popData.population - popData.populationInCities;
                allPopulationData.add(popData);
            }
            return allPopulationData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the requested population data.");
            return null;
        }
    }

    public static ArrayList<PopulationData> getPopulationDataRegion(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.region, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.region; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population of regions
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.identifier = rset.getString("country.region");
                popData.population = getPopulationOfContinent(con, popData.identifier);
                popData.populationInCities = rset.getLong("citiesPopulation");
                popData.populationNotInCities = popData.population - popData.populationInCities;
                allPopulationData.add(popData);
            }
            return allPopulationData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the requested population data.");
            return null;
        }
    }

    /**
     * Method to print all population data of each continent in the ArrayList
     * @param popData
     */
    public static void printPopulationDataContinent(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %15s %15s %15s", "Continent", "TotalPopulation", "PopulationInCities", "PopulationNotInCities"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %15s %15s %15s",
                    populationData.identifier, populationData.population, populationData.populationInCities, populationData.populationNotInCities);
            System.out.println(dataString);
        }
    }

    public static void printPopulationDataRegion(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %15s %15s %15s", "Region", "TotalPopulation", "PopulationInCities", "PopulationNotInCities"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %15s %15s %15s",
                    populationData.identifier, populationData.population, populationData.populationInCities, populationData.populationNotInCities);
            System.out.println(dataString);
        }
    }
}
