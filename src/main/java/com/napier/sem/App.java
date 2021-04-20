package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.Languages;
import com.napier.sem.world.PopulationData;


import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/04/2021
 * Purpose of program: Run SQL queries to satisfy the given requirements
 * Please remove comments for any other queries you would like to see
 * Last modified by: Colin
 */

public class App
{
    public static void main(String[] args) {
        // Status update
        System.out.println("Final Example with 4 functions");
        System.out.println("Database Connection has 2 attempts...");
        // Database connection setup
        DbConnection dbc = new DbConnection();
        Connection con = dbc.getConnection();

        if (args.length < 1)
            dbc.connect("localhost:33060");

        else
            dbc.connect(args[0]);


        // ************** COUNTRIES FUNCTIONS ***************** Author: Luke */

        // Report 1.1 - Return all countries in the world to allCountriesInWorld object
        //ArrayList<Country> allCountriesInWorld = Sql.getAllCountriesInWorld(con);
        // Display report from allCountriesInWorld
        //if (allCountriesInWorld != null) {
         //  Reports.printCountries(allCountriesInWorld);
        //}else{
        //    System.out.println("Error getting all countries in the world");
        //}

        // Report 1.2 - Return all countries in a continent to allCountriesInContinent object
        //ArrayList<Country> allCountriesInContinent = Sql.getAllCountriesInContinent(con, "Europe");
        // Display report from allCountriesInContinent
        //if (allCountriesInContinent != null) {
        //    Reports.printCountries(allCountriesInContinent);
        //}else{
         //   System.out.println("Error getting all countries in continent");
         //}

        // Report 1.3 - Return all countries in a region to allCountriesByRegion object
        //ArrayList<Country> allCountriesByRegion = Sql.getAllCountriesByRegion(con, "Caribbean");
        // Display report from allCountriesByRegion
        //if (allCountriesByRegion != null){
        //    Reports.printCountries(allCountriesByRegion);
        //}else{
         //   System.out.println("Error getting all countries by region");
        //}

        // Report 1.4 - Return the top N countries in the world to topPopulatedCountriesInWorld object
        //ArrayList<Country> topPopulatedCountriesInWorld = Sql.getTopPopulatedCountriesInWorld(con, 20);
        // Display report from topPopulatedCountriesInWorld
        //if (topPopulatedCountriesInWorld != null) {
          //  Reports.printCountries(topPopulatedCountriesInWorld);
        //}else{
         //   System.out.println("Error getting top populated countries in world");
       // }

        // Report 1.5 - Return the top N countries in a continent to topPopulatedCountriesInContinent object
        ArrayList<Country> topPopulatedCountriesInContinent = Sql.getTopPopulatedCountriesInContinent(con, "Europe", 20);
        // Display report from topPopulatedCountriesInContinent
        if (topPopulatedCountriesInContinent != null) {
            Reports.printCountries(topPopulatedCountriesInContinent);
        }else {
            System.out.println("Error getting top populated countries in continent");
        }

        // Report 1.6 - Return the top N countries in a region to topPopulatedCountriesInRegion object
        //ArrayList<Country> topPopulatedCountriesInRegion = Sql.getTopPopulatedCountriesInRegion(con, "Caribbean", 20);
        // Display report from topPopulatedCountriesInRegion
        //if (topPopulatedCountriesInRegion != null) {
        //    Reports.printCountries(topPopulatedCountriesInRegion);
        //}else{
        //    System.out.println("Error getting top populated countries in region");
        //}

        // ************** CITIES FUNCTIONS ***************** Author: Colin //

        // Report 2.1 - Return all cities in world to allCitiesInWorld object
        //ArrayList<City> allCitiesInWorld = Sql.getAllCitiesInWorld(con);
        // Display report from allCitiesInWorld
        //if (allCitiesInWorld != null) {
         //   Reports.printCities(allCitiesInWorld);
        //}else {
        //    System.out.println("Error getting all cities in world");
        //}

        // Report 2.2 - Return all cities in a continent to allCitiesInContinent object
        //ArrayList<City> allCitiesInContinent = Sql.getAllCitiesInContinent(con, "Asia");
        // Display report from allCitiesInContinent
        //if (allCitiesInContinent != null) {
        //    Reports.printCities(allCitiesInContinent);
        //}else{
        //    System.out.println("Error getting all cities in continent");
        //}


        // Report 2.3 - Return all cities in a region to allCitiesInRegion object
        //ArrayList<City> allCitiesInRegion = Sql.getAllCitiesInRegion(con, "Caribbean");
        // Display report from allCitiesInRegion
        //if (allCitiesInRegion != null) {
        //    Reports.printCities(allCitiesInRegion);
        //}else{
        //    System.out.println("Error getting all cities in region");

        //}


        // Report 2.4 - Return all cities in a country to allCitiesInCountry object
        //ArrayList<City> allCitiesInCountry = Sql.getAllCitiesInCountry(con, "Brazil");
        // Display report from allCitiesInCountry
        //if (allCitiesInCountry != null) {
        //    Reports.printCities(allCitiesInCountry);
        //}else{
        //    System.out.println("Error getting all cities in country");

        //}


        // Report 2.5 - Return all cities in a district to allCitiesInDistrict object
        //ArrayList<City> allCitiesInDistrict = Sql.getAllCitiesInDistrict(con, "Scotland");
        // Display report from allCitiesInDistrict
        //if (allCitiesInDistrict != null) {
         //   Reports.printCities(allCitiesInDistrict);
        //}else{
        //    System.out.println("Error getting all cities in district");

        //}


        // Report 2.6 - Return top N populated cities in the world to topPopulatedCitiesInWorld object
        //ArrayList<City> topPopulatedCitiesInWorld = Sql.getTopPopulatedCitiesInWorld(con, 20);
        // Display report from topPopulatedCitiesInWorld
        //if(topPopulatedCitiesInWorld != null) {
        //    Reports.printCities(topPopulatedCitiesInWorld);
        //}else{
        //   System.out.println("Error getting top 10 most populous cities in the world");
        //}

        // Report 2.7 - Return top N populated cities in a continent to topPopulatedCitiesInContinent object
        //ArrayList<City> topPopulatedCitiesInContinent = Sql.getTopPopulatedCitiesInContinent(con, 20, "Asia");
        // Display report from topPopulatedCitiesInContinent
        //if (topPopulatedCitiesInContinent != null) {
        //    Reports.printCities(topPopulatedCitiesInContinent);
        //}else {
         //   System.out.println("Error getting top N most populous cities in continent");

        //}


        // Report 2.8 - Return top N populated cities in a region to topPopulatedCitiesInRegion object
        //ArrayList<City> topPopulatedCitiesInRegion = Sql.getTopPopulatedCitiesInRegion(con, 20, "Caribbean");
        // Display report from topPopulatedCitiesInRegion
        //if (topPopulatedCitiesInRegion != null) {
        //    Reports.printCities(topPopulatedCitiesInRegion);
        //}else {
         //   System.out.println("Error getting top N most populous cities in region");

        //}


        // Report 2.9 - Return top N populated cities in the world to topPopulatedCitiesInCountry object
        //ArrayList<City> topPopulatedCitiesInCountry = Sql.getTopPopulatedCitiesInCountry(con, 20, "Brazil");
        // Display report from topPopulatedCitiesInCountry
        //if (topPopulatedCitiesInCountry != null) {
         //   Reports.printCities(topPopulatedCitiesInCountry);
        //}else{
         //   System.out.println("Error getting top N most populous cities in country");

        //}


        // Report 2.10 - Return top N populated cities in the world to topPopulatedCitiesInDistrict object
        ArrayList<City> topPopulatedCitiesInDistrict = Sql.getTopPopulatedCitiesInDistrict(con, 20, "England");
        //Display report from topPopulatedCitiesInDistrict
        if (topPopulatedCitiesInDistrict != null) {
            Reports.printCities(topPopulatedCitiesInDistrict);
        }else {
            System.out.println("Error getting top N most populous cities in district");

        }


        // ************** CAPITAL CITIES FUNCTIONS ***************** Author: Del //

        // Report 3.1 - Return all the world's capitals by descending population
        //ArrayList<City> biggestCapitals = Sql.getBiggestWorldCapitals(con);
        //if (biggestCapitals != null) {
        //    Reports.printCapitals(biggestCapitals);
        //}else{
        //    System.out.println("Error getting all capitals in the world");

        //}


        // Report 3.2 - Return all of Europe's capitals by descending population
        //ArrayList<City> biggestEuropeCapitals = Sql.getBiggestContinentCapitals(con, "Europe");
        //if (biggestEuropeCapitals != null) {
        //    Reports.printCapitals(biggestEuropeCapitals);
        //}else{
        //    System.out.println("Error getting all capital cities in a continent");

        //}


        // Report 3.3 - Return all of Southeast Asia's capitals by descending population
        //ArrayList<City> biggestSEAsiaCapitals = Sql.getBiggestRegionCapitals(con, "Southeast Asia");
        //if (biggestSEAsiaCapitals != null) {
        //    Reports.printCapitals(biggestSEAsiaCapitals);
        //}else{
        //    System.out.println("Error getting all capital cities in a region");

        //}


        // Report 3.4 - Return the top 3 most populous capitals across the world by descending population
        //ArrayList<City> biggestNCapitals = Sql.getNBiggestWorldCapitals(con, 20);
        //if(biggestNCapitals != null) {
        //    Reports.printCapitals(biggestNCapitals);
        //}else{
         //   System.out.println("Error getting N biggest capitals in the world");
        //}


        // Report 3.5 - Return the top 3 largest capitals in Europe by descending population
        //ArrayList<City> biggest3EuropeCapitals = Sql.getNBiggestContinentCapitals(con, 20, "Europe");
        //if (biggest3EuropeCapitals != null) {
        //    Reports.printCapitals(biggest3EuropeCapitals);
        //}else {
       //     System.out.println("Error getting N biggest capitals in a continent");

        //}


        // Report 3.6 - Return the top 3 largest capitals in Southeast Asia by descending population
        ArrayList<City> biggest3SEAsiaCapitals = Sql.getNBiggestRegionCapitals(con, 20, "Southeast Asia");
        if (biggest3SEAsiaCapitals != null) {
            Reports.printCapitals(biggest3SEAsiaCapitals);
        }else{
            System.out.println("Error getting N biggest capitals in a region");

        }



        // ************** POPULATION FUNCTIONS ***************** Author: Cameron //

        // Report 4.1 - The population of people, people living in cities, and people not living in cities in each continent.
        // Antarctica is not shown as the population is set to 0 in the database //
        //ArrayList<PopulationData> continentPopulationDataList = Sql.getPopulationDataContinent(con);
        //if(continentPopulationDataList != null) {
        //    Reports.printPopulationDataContinent(continentPopulationDataList);
        //}else{
        //    System.out.println("Error getting total, urban and rural population per continent.");
        //}

        // Report 4.2 - The population of people, people living in cities, and people not living in cities in each region.
        //ArrayList<PopulationData> regionPopulationDataList = Sql.getPopulationDataRegion(con);
        //if (regionPopulationDataList != null) {
        //    Reports.printPopulationDataRegion(regionPopulationDataList);
        //}else{
        //    System.out.println("Error getting total, urban and rural population per region.");

        //}



        // Report 4.3 - The population of people, people living in cities, and people not living in cities in each country.
        ArrayList<PopulationData> countryPopulationDataList = Sql.getPopulationDataCountry(con);
        if (countryPopulationDataList != null ) {
            Reports.printPopulationDataCountry(countryPopulationDataList);
        }else{
            System.out.println("Error getting total, urban and rural population per country.");

        }

        // ************** ADDITIONAL FUNCTIONS ***************** Author Cameron //
        // Report 5.1 - Get population of the world
        // Long totalPopulation = Sql.getWorldPopulation(con);
        // System.out.println("World Population: " + totalPopulation);

        // Report 5.2 - Get population of a continent
        // Set continent to get population of
        // 'Asia','Europe','North America','Africa','Oceania','Antarctica','South America'
        // String continent = "Europe";
        // Long continentPopulation = Sql.getPopulationOfContinent(con, continent);
        // System.out.println("Population of " + continent + " is " + continentPopulation);

        // Report 5.3 - Get population of a region
        // Set region to get population of
        // String region = "Southern Europe";
        // Long regionPopulation = Sql.getPopulationOfRegion(con, region);
        // System.out.println("Population of " + region + " is " + regionPopulation);

        // Report 5.4 - Get the population of a country
        // Set the country code
        // String code = "GBR";
        // Long countryPopulation = Sql.getPopulationOfCountry(con, code);
        // System.out.println("The population of " + code + " is " + countryPopulation);

        // Report 5.5 - Get the population of a district
        // Set the district
        // String district = "England";
        // Long districtPopulation = Sql.getDistrictPopulation(con, district);
        // System.out.println("The population of " + district + " is " + districtPopulation);

        // Report 5.6 - Get the population of a city
        // Set the city name
        // String cityName = "London";
        // Long cityPopulation = Sql.getCityPopulation(con, cityName);
        // System.out.println("The population of " + cityName + " is " + cityPopulation);

        // ************** LANGUAGE FUNCTIONS ***************** Author Cameron //

        // Report 6.1 - Return all the who speak English from greatest to smallest + percentage of world population:
        //ArrayList<Languages> languageDataEnglish = Sql.getNumberOfLanguageSpeakers(con, "English");
        //if(languageDataEnglish != null){
        //    Reports.printLanguageData(languageDataEnglish);
        //}else {
        //    System.out.println("Error getting Language Data for the English language.");
        //}

        // Report 6.2 - Return all the who speak Chinese from greatest to smallest + percentage of world population:
        //ArrayList<Languages> languageDataChinese = Sql.getNumberOfLanguageSpeakers(con, "Chinese");
        //if(languageDataChinese != null){
        //    Reports.printLanguageData(languageDataChinese);
        //}else {
        //    System.out.println("Error getting Language Data for the Chinese language.");
        //}

        // Report 6.3 - Return all the who speak Hindi from greatest to smallest + percentage of world population:
        //ArrayList<Languages> languageDataHindi = Sql.getNumberOfLanguageSpeakers(con, "Hindi");
        //if(languageDataHindi != null){
        //    Reports.printLanguageData(languageDataHindi);
        //}else {
        //    System.out.println("Error getting Language Data for the Hindi language.");
        //}

        // Report 6.4 - Return all the who speak Spanish from greatest to smallest + percentage of world population:
        //ArrayList<Languages> languageDataSpanish = Sql.getNumberOfLanguageSpeakers(con, "Spanish");
        //if(languageDataSpanish != null){
        //    Reports.printLanguageData(languageDataSpanish);
        //}else {
        //    System.out.println("Error getting Language Data for the Spanish language.");
        //}

        // Report 6.5 - Return all the who speak Arabic from greatest to smallest + percentage of world population:
        //ArrayList<Languages> languageDataArabic = Sql.getNumberOfLanguageSpeakers(con, "Arabic");
        //if(languageDataArabic != null){
        //    Reports.printLanguageData(languageDataArabic);
        //}else {
        //    System.out.println("Error getting Language Data for the Arabic language.");
        //}



        // Disconnect from database
        dbc.disconnect();
    }
}