package com.napier.sem;

import java.sql.*;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 21/02/2021
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

        // Additional Information Reports //
        // Report 1:
        // Get population of the world
        Long totalPopulation = AdditionalReports.getWorldPopulation(con);
        System.out.println("World Population: " + totalPopulation);

        // Report 2:
        // Get population of given continent
        // Set continent to get population of
        // 'Asia','Europe','North America','Africa','Oceania','Antarctica','South America'
        String continent = "Europe";
        Long continentPopulation = AdditionalReports.getPopulationOfContinent(con, continent);
        System.out.println("Population of " + continent + " is " + continentPopulation);

        // Report 3:
        // Get population of given region
        // Set region to get population of
        String region = "Southern Europe";
        Long regionPopulation = AdditionalReports.getPopulationOfRegion(con, region);
        System.out.println("Population of " + region + " is " + regionPopulation);

        // Report 4:
        // Get the population of given country
        // Set the country code
        String code = "GBR";
        Long countryPopulation = AdditionalReports.getCountryPopulation(con, code);
        System.out.println("The population of " + code + " is " + countryPopulation);

        // Report 5:
        // Get the population of given district
        // Set the district
        String district = "England";
        Long districtPopulation = AdditionalReports.getDistrictPopulation(con, district);
        System.out.println("The population of " + district + " is " + districtPopulation);

        // Report 6:
        // Get the population of a city
        // Set the city name
        String cityName = "London";
        Long cityPopulation = AdditionalReports.getCityPopulation(con, cityName);
        System.out.println("The population of " + cityName + " is " + cityPopulation);

        // Disconnect from database
        dbc.disconnect();
    }
}