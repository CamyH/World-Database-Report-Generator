package com.napier.sem.report;

import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;

import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 22/02/2021
 * Purpose of class: This class handles the reports to the console.
 */


public class Reports {

    /**
     * Method to print the cities report from the arraylist object
     * @param cities object with data
     */
    public static void printCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
    }

    public static void printCapitals(ArrayList<City> capitals)
    {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s", "Name", "Country", "Population"));
        // Loop over all capitals in the list
        for (City city : capitals)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s",
                            city.name, city.country, city.population);
            System.out.println(city_string);
        }
    }

    /**
     * Method to print all population data of each continent in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataContinent(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s", "Continent", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                "PopulationNotInCities", "PopulationNotInCities(%)"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                    populationData.identifier, populationData.population, populationData.populationInCities,
                    Math.round(populationData.populationPercentInCities), populationData.populationNotInCities, Math.round(populationData.populationPercentNotInCities));
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all population data of each region in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataRegion(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s", "Region", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                "PopulationNotInCities", "PopulationNotInCities(%)"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                    populationData.identifier, populationData.population, populationData.populationInCities, Math.round(populationData.populationPercentInCities),
                    populationData.populationNotInCities, Math.round(populationData.populationPercentNotInCities));
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all population data of each country in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataCountry(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s", "Country", "TotalPopulation", "PopulationInCities", "PopulationInCities(%)",
                "PopulationNotInCities", "PopulationNotInCities(%)"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                    populationData.identifier, populationData.population, populationData.populationInCities,
                    Math.round(populationData.populationPercentInCities), populationData.populationNotInCities, Math.round(populationData.populationPercentNotInCities));
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all countries and their population from largest to smallest
     * @param countries
     */
    public static void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s %-30s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                            country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }
}
