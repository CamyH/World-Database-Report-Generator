package com.napier.sem.report;

import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;

import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 06/03/2021
 * Purpose of class: This class handles the reports to the console.
 * Last modified by: Del
 */


public class Reports {

    /**
     * Method to print the cities report from the arraylist object
     * @param cities object with data
     */
    public static void printCities(ArrayList<City> cities)
    {
        if(cities == null){
            System.out.println("No Country Data");
        }
        else{


        // Print header
        System.out.printf("%-30s %-30s %-30s %-30s%n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city : cities)
        {
            if(city == null)
                continue;
            String city_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
            System.out.println(city_string);
            }
        }
    }

    public static void printCapitals(ArrayList<City> capitals)
    {
        // Print header
        System.out.printf("%-30s %-30s %-30s%n", "Name", "Country", "Population");
        // Loop over all capitals in the list
        for (City city : capitals)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s",
                            city.getName(), city.getCountry(), city.getPopulation());
            System.out.println(city_string);
        }
    }

    /**
     * Method to print all population data of each continent in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataContinent(ArrayList<PopulationData> popData) {
        if(popData == null){
            System.out.println("No Population Data");
        }
        else {
            // Print header
            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Continent", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                    "PopulationNotInCities", "PopulationNotInCities(%)");
            // Loop over all population data in the list
            for (PopulationData populationData : popData) {
                if(populationData == null)
                    continue;
                String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                        populationData.getIdentifier(), populationData.getPopulation(), populationData.getPopulationInCities(),
                        Math.round(populationData.getPopulationPercentInCities()), populationData.getPopulationNotInCities(), Math.round(populationData.getPopulationPercentNotInCities()));
                System.out.println(dataString);
            }
        }
    }

    /**
     * Method to print all population data of each region in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataRegion(ArrayList<PopulationData> popData) {
        if(popData == null){
            System.out.println("No Population Data");
        }
        else {
            // Print header
            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Region", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                    "PopulationNotInCities", "PopulationNotInCities(%)");
            // Loop over all population data in the list
            for (PopulationData populationData : popData) {
                if(populationData == null)
                    continue;
                String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                        populationData.getIdentifier(), populationData.getPopulation(), populationData.getPopulationInCities(), Math.round(populationData.getPopulationPercentInCities()),
                        populationData.getPopulationNotInCities(), Math.round(populationData.getPopulationPercentNotInCities()));
                System.out.println(dataString);
            }
        }
    }

    /**
     * Method to print all population data of each country in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataCountry(ArrayList<PopulationData> popData) {
        if(popData == null){
            System.out.println("No Population Data");
        }

        else {
            // Print header
            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Country", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                    "PopulationNotInCities", "PopulationNotInCities(%)");
            // Loop over all population data in the list
            for (PopulationData populationData : popData) {
                if(populationData == null)
                    continue;
                String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                        populationData.getIdentifier(), populationData.getPopulation(), populationData.getPopulationInCities(),
                        Math.round(populationData.getPopulationPercentInCities()), populationData.getPopulationNotInCities(), Math.round(populationData.getPopulationPercentNotInCities()));
                System.out.println(dataString);
            }
        }
    }

    /**
     * Method to print all countries and their population from largest to smallest
     * @param countries ArrayList of countries to print data for
     */
    public static void printCountries(ArrayList<Country> countries)
    {
        if(countries == null){
            System.out.println("No Country Data");
        }
        else {
            // Print header
            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");

            // Loop over all countries in the list
            for (Country country : countries) {
                if(country == null)
                    continue;
                String country_string =
                        String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                                country.getCode(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), country.getCapital());
                System.out.println(country_string);
            }
        }
    }
}
