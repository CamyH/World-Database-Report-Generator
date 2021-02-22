package com.napier.sem.sql;

import com.napier.sem.world.PopulationData;

import java.sql.*;
import java.util.ArrayList;

/**
 * Author: Cameron
 * Date last modified: 22/02/2021
 * Purpose of class: Contains methods to return population data for specific requirements.
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
            // Create string for SQL statement
            String continentPopulation = "SELECT SUM(population) as continentPopulation " +
                    "FROM country " +
                    "WHERE continent = ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(continentPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, continent);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
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
            // Create string for SQL statement
            String regionPopulation = "SELECT SUM(population) as regionPopulation " +
                    "FROM country " +
                    "WHERE region = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(regionPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, region);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
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
            // Create string for SQL statement
            String countryPopulation = "SELECT name, population " +
                    "FROM country " +
                    "WHERE code = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(countryPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, code);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
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
            // Create string for SQL statement
            String districtPopulation = "SELECT SUM(population) as districtPopulation " +
                    "FROM city " +
                    "WHERE district = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(districtPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, district);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
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
            // Create string for SQL statement
            String cityPopulation = "SELECT population " +
                    "FROM city " +
                    "WHERE name = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(cityPopulation);
            // Set SQL statement ? to cityName parameter
            preparedStatement.setString(1, cityName);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
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
            // Return population data of each continent
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

    /**
     * Method to return a list of population data for each region
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each region in an ArrayList,
     * or null if there is an error.
     */
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
            // Return population data of each region
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.identifier = rset.getString("country.region");
                popData.population = getPopulationOfRegion(con, popData.identifier);
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
     * Method to return a list of population data for each country
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each country in an ArrayList,
     * or null if there is an error.
     */
    public static ArrayList<PopulationData> getPopulationDataCountry(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.code, country.name, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.name, country.code; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population data of each country
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.code = rset.getString("country.code");
                popData.identifier = rset.getString("country.name");
                popData.population = getCountryPopulation(con, popData.code);
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
}
