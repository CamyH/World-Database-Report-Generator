package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.AdditionalReports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 22/02/2021
 * Purpose of program: To run SQL queries to satisfy the given requirements
 * Last modified by: Cameron
 */

public class App
{
    public static void main(String[] args)
    {
        // Status update
        System.out.println("Added Con & tidied up tested full - working");

        // Database connection setup
        DbConnection dbc = new DbConnection();
        Connection con = dbc.getConnection();
        Sql query = new Sql();
        Reports report = new Reports();

        // Return all countries in world to countries1 object
        ArrayList<Country> countries1 = query.getAllCountriesInWorld(con);
        // Display report from countries1
        report.printCountriesInWorld(countries1);

        // Return all countries in world to countries1 object
        ArrayList<Country> countries2 = query.getAllCountriesInContinent(con, "Europe");
        // Display report from countries1
        report.printCountriesInContinent(countries2);

        // Return all countries in world to countries1 object
        ArrayList<Country> countries3 = query.getAllCountriesByRegion(con, "Caribbean");
        // Display report from countries1
        report.printCountriesInRegion(countries3);

        // Return all countries in world to countries1 object
        ArrayList<Country> countries4 = query.getTopPopulatedCountriesInWorld(con, 10);
        // Display report from countries1
        report.printCountriesInWorld(countries4);

        // Return all countries in world to countries1 object
        ArrayList<Country> countries5 = query.getTopPopulatedCountriesInContinent(con, "Europe", 10);
        // Display report from countries1
        report.printCountriesInContinent(countries5);

        // Return all countries in world to countries1 object
        ArrayList<Country> countries6 = query.getTopPopulatedCountriesInRegion(con, "Caribbean", 10);
        // Display report from countries1
        report.printCountriesInRegion(countries6);

        // Return all cities in world to cities7 object
        Sql query7 = new Sql();
        ArrayList<City> cities7 = query7.getAllCitiesInWorld(con);

        // Display report from cities7
        Reports report7 = new Reports();
        //report7.printCities(cities7);

        // Return all cities in a continent to cities8 object
        Sql query8 = new Sql();
        ArrayList<City> cities8 = query8.getAllCitiesInContinent(con, "Asia");

        // Display report from cities8
        Reports report8 = new Reports();
        //report8.printCities(cities8);

        // Return all cities in a region to cities9 object
        Sql query9 = new Sql();
        ArrayList<City> cities9 = query9.getAllCitiesInRegion(con, "Caribbean");

        // Display report from cities9
        Reports report9 = new Reports();
        //report9.printCities(cities9);

        // Return all cities in a region to cities10 object
        Sql query10 = new Sql();
        ArrayList<City> cities10 = query10.getAllCitiesInCountry(con, "Brazil");

        // Display report from cities10
        Reports report10 = new Reports();
        //report10.printCities(cities10);

        // Return all cities in a district to cities11 object
        Sql query11 = new Sql();
        ArrayList<City> cities11 = query11.getAllCitiesInDistrict(con, "Scotland");

        // Display report from cities11
        Reports report11 = new Reports();
        //report11.printCities(cities11);

        // Return top N populated cities in the world to cities12 object
        Sql query12 = new Sql();
        ArrayList<City> cities12 = query12.getTopPopulatedCitiesInWorld(con, 10);

        // Display report from cities12
        Reports report12 = new Reports();
        //report12.printCities(cities12);

        // Return top N populated cities in a continent to cities13 object
        Sql query13 = new Sql();
        ArrayList<City> cities13 = query13.getTopPopulatedCitiesInContinent(con, 10, "Asia");

        // Display report from cities13
        Reports report13 = new Reports();
        //report13.printCities(cities13);

        // Return top N populated cities in a region to cities14 object
        Sql query14 = new Sql();
        ArrayList<City> cities14 = query14.getTopPopulatedCitiesInRegion(con, 10, "Caribbean");

        // Display report from cities14
        Reports report14 = new Reports();
        //report14.printCities(cities14);

        // Return top N populated cities in the world to cities15 object
        Sql query15 = new Sql();
        ArrayList<City> cities15 = query15.getTopPopulatedCitiesInCountry(con, 10, "Brazil");

        // Display report from cities15
        Reports report15 = new Reports();
        //report15.printCities(cities15);

        // Return top N populated cities in the world to cities16 object
        Sql query16 = new Sql();
        ArrayList<City> cities16 = query16.getTopPopulatedCitiesInDistrict(con, 10, "Scotland");

        // Display report from cities16
        Reports report16 = new Reports();
        //report16.printCities(cities16);


        // Additional Information Reports //
        // Report 1:
        // Get population of the world
        // Long totalPopulation = AdditionalReports.getWorldPopulation(con);
        // System.out.println("World Population: " + totalPopulation);

        // Report 2:
        // Get population of a continent
        // Set continent to get population of
        // 'Asia','Europe','North America','Africa','Oceania','Antarctica','South America'
        // String continent = "Europe";
        // Long continentPopulation = AdditionalReports.getPopulationOfContinent(con, continent);
        // System.out.println("Population of " + continent + " is " + continentPopulation);

        // Report 3:
        // Get population of a region
        // Set region to get population of
        //String region = "Southern Europe";
        //Long regionPopulation = AdditionalReports.getPopulationOfRegion(con, region);
        //System.out.println("Population of " + region + " is " + regionPopulation);

        // Report 4:
        // Get the population of a country
        // Set the country code
        //String code = "GBR";
        //Long countryPopulation = AdditionalReports.getCountryPopulation(con, code);
        //System.out.println("The population of " + code + " is " + countryPopulation);

        // Report 5:
        // Get the population of a district
        // Set the district
        //String district = "England";
        //Long districtPopulation = AdditionalReports.getDistrictPopulation(con, district);
        //System.out.println("The population of " + district + " is " + districtPopulation);

        // Report 6:
        // Get the population of a city
        // Set the city name
        //String cityName = "London";
        //Long cityPopulation = AdditionalReports.getCityPopulation(con, cityName);
        //System.out.println("The population of " + cityName + " is " + cityPopulation);

        // Population of people... reports //
        // Report 1:
        // The population of people, people living in cities, and people not living in cities in each continent.
        // Antarctica is not shown as the population is set to 0 in the database //
        //ArrayList<PopulationData> continentPopulationDataList = AdditionalReports.getPopulationDataContinent(con);
        //Reports.printPopulationDataContinent(continentPopulationDataList);

        // Report 2:
        // The population of people, people living in cities, and people not living in cities in each region.
        //ArrayList<PopulationData> regionPopulationDataList = AdditionalReports.getPopulationDataRegion(con);
        //Reports.printPopulationDataRegion(regionPopulationDataList);

        // Report 3:
        // The population of people, people living in cities, and people not living in cities in each country.
        //ArrayList<PopulationData> countryPopulationDataList = AdditionalReports.getPopulationDataCountry(con);
        //Reports.printPopulationDataCountry(countryPopulationDataList);

        // Disconnect from database
        dbc.disconnect();
    }
}