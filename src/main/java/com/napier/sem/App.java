package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;


import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 06/03/2021
 * Purpose of program: Run SQL queries to satisfy the given requirements
 * Last modified by: Del
 */

public class App
{
    public static void main(String[] args)
    {
        // Status update
        System.out.println("Showing a test function from everyone's work");

        // Database connection setup
        DbConnection dbc = new DbConnection();
        Connection con = dbc.getConnection();

        // ************** COUNTRIES FUNCTIONS ***************** Author: Luke */
/*
        // Report 1.1 - Return all countries in the world to allCountriesInWorld object
        ArrayList<Country> allCountriesInWorld = Sql.getAllCountriesInWorld(con);
        // Display report from allCountriesInWorld
        Reports.printCountries(allCountriesInWorld);

        // Report 1.2 - Return all countries in a continent to allCountriesInContinent object
        ArrayList<Country> allCountriesInContinent = Sql.getAllCountriesInContinent(con, "Europe");
        // Display report from allCountriesInContinent
        Reports.printCountries(allCountriesInContinent);

        // Report 1.3 - Return all countries in a region to allCountriesByRegion object
        ArrayList<Country> allCountriesByRegion = Sql.getAllCountriesByRegion(con, "Caribbean");
        // Display report from allCountriesByRegion
        Reports.printCountries(allCountriesByRegion);
*/
        // Report 1.4 - Return the top N countries in the world to topPopulatedCountriesInWorld object
        ArrayList<Country> topPopulatedCountriesInWorld = Sql.getTopPopulatedCountriesInWorld(con, 10);
        // Display report from topPopulatedCountriesInWorld
        if(topPopulatedCountriesInWorld != null) {
            Reports.printCountries(topPopulatedCountriesInWorld);
        }else{
            System.out.println("Error getting top 10 most populous cities in the world.");
        }
/*
        // Report 1.5 - Return the top N countries in a continent to topPopulatedCountriesInContinent object
        ArrayList<Country> topPopulatedCountriesInContinent = Sql.getTopPopulatedCountriesInContinent(con, "Europe", 10);
        // Display report from topPopulatedCountriesInContinent
        Reports.printCountries(topPopulatedCountriesInContinent);

        // Report 1.6 - Return the top N countries in a region to topPopulatedCountriesInRegion object
        ArrayList<Country> topPopulatedCountriesInRegion = Sql.getTopPopulatedCountriesInRegion(con, "Caribbean", 10);
        // Display report from topPopulatedCountriesInRegion
        Reports.printCountries(topPopulatedCountriesInRegion);
*/
        // ************** CITIES FUNCTIONS ***************** Author: Colin //
/*
        // Report 2.1 - Return all cities in world to allCitiesInWorld object
        ArrayList<City> allCitiesInWorld = Sql.getAllCitiesInWorld(con);
        // Display report from allCitiesInWorld
        assert allCitiesInWorld != null;
        Reports.printCities(allCitiesInWorld);

        // Report 2.2 - Return all cities in a continent to allCitiesInContinent object
        ArrayList<City> allCitiesInContinent = Sql.getAllCitiesInContinent(con, "Asia");
        // Display report from allCitiesInContinent
        Reports.printCities(allCitiesInContinent);

        // Report 2.3 - Return all cities in a region to allCitiesInRegion object
        ArrayList<City> allCitiesInRegion = Sql.getAllCitiesInRegion(con, "Caribbean");
        // Display report from allCitiesInRegion
        Reports.printCities(allCitiesInRegion);

        // Report 2.4 - Return all cities in a region to allCitiesInCountry object
        ArrayList<City> allCitiesInCountry = Sql.getAllCitiesInCountry(con, "Brazil");
        // Display report from allCitiesInCountry
        Reports.printCities(allCitiesInCountry);

        // Report 2.5 - Return all cities in a district to allCitiesInDistrict object
        ArrayList<City> allCitiesInDistrict = Sql.getAllCitiesInDistrict(con, "Scotland");
        // Display report from allCitiesInDistrict
        Reports.printCities(allCitiesInDistrict);
*/
        // Report 2.6 - Return top N populated cities in the world to topPopulatedCitiesInWorld object
        ArrayList<City> topPopulatedCitiesInWorld = Sql.getTopPopulatedCitiesInWorld(con, 10);
        // Display report from topPopulatedCitiesInWorld
        if(topPopulatedCitiesInWorld != null) {
            Reports.printCities(topPopulatedCitiesInWorld);
        }else{
            System.out.println("Error getting top 10 most populous cities in the world");
        }
/*
        // Report 2.7 - Return top N populated cities in a continent to topPopulatedCitiesInContinent object
        ArrayList<City> topPopulatedCitiesInContinent = Sql.getTopPopulatedCitiesInContinent(con, 10, "Asia");
        // Display report from topPopulatedCitiesInContinent
        Reports.printCities(topPopulatedCitiesInContinent);

        // Report 2.8 - Return top N populated cities in a region to topPopulatedCitiesInRegion object
        ArrayList<City> topPopulatedCitiesInRegion = Sql.getTopPopulatedCitiesInRegion(con, 10, "Caribbean");
        // Display report from topPopulatedCitiesInRegion
        Reports.printCities(topPopulatedCitiesInRegion);

        // Report 2.9 - Return top N populated cities in the world to topPopulatedCitiesInCountry object
        ArrayList<City> topPopulatedCitiesInCountry = Sql.getTopPopulatedCitiesInCountry(con, 10, "Brazil");
        // Display report from topPopulatedCitiesInCountry
        Reports.printCities(topPopulatedCitiesInCountry);

        // Report 2.10 - Return top N populated cities in the world to topPopulatedCitiesInDistrict object
        ArrayList<City> topPopulatedCitiesInDistrict = Sql.getTopPopulatedCitiesInDistrict(con, 10, "Scotland");
        //Display report from topPopulatedCitiesInDistrict
        Reports.printCities(topPopulatedCitiesInDistrict);
*/
        // ************** CAPITAL CITIES FUNCTIONS ***************** Author: Del //
/*
        // Report 3.1 - Return all the world's capitals by descending population
        ArrayList<City> biggestCapitals = Sql.getBiggestWorldCapitals(con);
        Reports.printCapitals(biggestCapitals);

        // Report 3.2 - Return all of Europe's capitals by descending population
        ArrayList<City> biggestEuropeCapitals = Sql.getBiggestContinentCapitals(con, "Europe");
        Reports.printCapitals(biggestEuropeCapitals);

        // Report 3.3 - Return all of Southeast Asia's capitals by descending population
        ArrayList<City> biggestSEAsiaCapitals = Sql.getBiggestRegionCapitals(con, "Southeast Asia");
        Reports.printCapitals(biggestSEAsiaCapitals);
 */
        // Report 3.4 - Return the top 3 most populous capitals across the world by descending population
        ArrayList<City> biggestNCapitals = Sql.getNBiggestWorldCapitals(con, 10);
        if(biggestNCapitals != null) {
            Reports.printCapitals(biggestNCapitals);
        }else{
            System.out.println("Error getting biggest 3 capitals.");
        }
        /*
        // Report 3.5 - Return the top 3 largest capitals in Europe by descending population
        ArrayList<City> biggest3EuropeCapitals = Sql.getNBiggestContinentCapitals(con, 3, "Europe");
        Reports.printCapitals(biggest3EuropeCapitals);

        // Report 3.6 - Return the top 3 largest capitals in Southeast Asia by descending population
        ArrayList<City> biggest3SEAsiaCapitals = Sql.getNBiggestRegionCapitals(con, 3, "Southeast Asia");
        Reports.printCapitals(biggest3SEAsiaCapitals);
*/

        // ************** POPULATION FUNCTIONS ***************** Author: Cameron //

        // Report 4.1 - The population of people, people living in cities, and people not living in cities in each continent.
        // Antarctica is not shown as the population is set to 0 in the database //
        ArrayList<PopulationData> continentPopulationDataList = Sql.getPopulationDataContinent(con);
        if(continentPopulationDataList != null) {
            Reports.printPopulationDataContinent(continentPopulationDataList);
        }else{
            System.out.println("Error getting total, urban and rural population per continent.");
        }
/*
        // Report 4.2 - The population of people, people living in cities, and people not living in cities in each region.
        ArrayList<PopulationData> regionPopulationDataList = Sql.getPopulationDataRegion(con);
        Reports.printPopulationDataRegion(regionPopulationDataList);


        // Report 4.3 - The population of people, people living in cities, and people not living in cities in each country.
        ArrayList<PopulationData> countryPopulationDataList = Sql.getPopulationDataCountry(con);
        Reports.printPopulationDataCountry(countryPopulationDataList);
*/
        // ************** ADDITIONAL FUNCTIONS ***************** Author Cameron //
        // Report 1:
        // Get population of the world
        // Long totalPopulation = Sql.getWorldPopulation(con);
        // System.out.println("World Population: " + totalPopulation);

        // Report 2:
        // Get population of a continent
        // Set continent to get population of
        // 'Asia','Europe','North America','Africa','Oceania','Antarctica','South America'
        // String continent = "Europe";
        // Long continentPopulation = Sql.getPopulationOfContinent(con, continent);
        // System.out.println("Population of " + continent + " is " + continentPopulation);

        // Report 3:
        // Get population of a region
        // Set region to get population of
        // String region = "Southern Europe";
        // Long regionPopulation = Sql.getPopulationOfRegion(con, region);
        // System.out.println("Population of " + region + " is " + regionPopulation);

        // Report 4:
        // Get the population of a country
        // Set the country code
        // String code = "GBR";
        // Long countryPopulation = Sql.getCountryPopulation(con, code);
        // System.out.println("The population of " + code + " is " + countryPopulation);

        // Report 5:
        // Get the population of a district
        // Set the district
        // String district = "England";
        // Long districtPopulation = Sql.getDistrictPopulation(con, district);
        // System.out.println("The population of " + district + " is " + districtPopulation);

        // Report 6:
        // Get the population of a city
        // Set the city name
        // String cityName = "London";
        // Long cityPopulation = Sql.getCityPopulation(con, cityName);
        // System.out.println("The population of " + cityName + " is " + cityPopulation);



        // Disconnect from database
        dbc.disconnect();
    }
}