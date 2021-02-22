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

    public void printCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "Name", "Country", "District", "Population"));
        // Loop over all employees in the list
        for (City city : cities)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
    }

    /**
     * Method to print all population data of each continent in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataContinent(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-15s %-15s %-15s", "Continent", "TotalPopulation", "PopulationInCities", "PopulationNotInCities"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %15s %15s %15s",
                    populationData.identifier, populationData.population, populationData.populationInCities, populationData.populationNotInCities);
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all population data of each region in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataRegion(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-15s %-15s %-15s", "Region", "TotalPopulation", "PopulationInCities", "PopulationNotInCities"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %15s %15s %15s",
                    populationData.identifier, populationData.population, populationData.populationInCities, populationData.populationNotInCities);
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all population data of each country in the ArrayList
     * @param popData ArrayList of data
     */
    public static void printPopulationDataCountry(ArrayList<PopulationData> popData) {
        // Print header
        System.out.println(String.format("%-30s %-15s %-15s %-15s", "Country", "TotalPopulation", "PopulationInCities", "PopulationNotInCities"));
        // Loop over all population data in the list
        for (PopulationData populationData : popData) {
            String dataString = String.format("%-30s %15s %15s %15s",
                    populationData.identifier, populationData.population, populationData.populationInCities, populationData.populationNotInCities);
            System.out.println(dataString);
        }
    }

    /**
     * Method to print all countries and their population from largest to smallest
     * @param countries
     */
    public void printCountriesInWorld(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s", "Name", "Population"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s",
                            country.name, country.population);
            System.out.println(country_string);
        }
    }

    /**
     * Method to print countries and their population of a specified continent from smallest to largest
     * @param countries
     */
    public void printCountriesInContinent(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-10s", "Name", "Population", "Continent"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-10s",
                            country.name, country.population, country.continent);
            System.out.println(country_string);
        }
    }

    /**
     * Method to print countries and their population of a specified region from smalled to largest
     * @param countries
     */
    public void printCountriesInRegion(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-10s", "Name", "Population", "Region"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-10s",
                            country.name, country.population, country.region);
            System.out.println(country_string);
        }
    }
}
