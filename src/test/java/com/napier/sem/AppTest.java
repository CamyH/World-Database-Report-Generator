package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.Languages;
import com.napier.sem.world.PopulationData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 03/04/2021
 * Purpose of program: Execute a suite of functional tests for the application.
 * Last modified by: Del
 */
public class AppTest
{
    static App app;
    static Reports reports;

    /**
     * Prepare for the tests by initialising the App and Reports classes.
     */
    @BeforeAll
    static void init()
    {
        // Init new instances of App & Reports
        app = new App();
        reports = new Reports();

    }

    //************** COUNTRIES UNIT TESTS ***************** Author Luke */
    /*
     * Series of unit tests regarding the Country-based functions as authored by Luke.
     */

    /**
     * Attempt to print an empty Countries report.
     */
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Reports.printCountries(countries);
    }

    /**
     * Attempt to print a null Countries report.
     */
    @Test
    void printCountriesTestNull()
    {
        Reports.printCountries(null);
    }

    /**
     * Attempt to print a Countries report with a single entry which is null.
     */
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        Reports.printCountries(countries);
    }

    /**
     * Create a simple Country object and attempt to print it.
     */
    @Test
    void printCountriesTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setCode("ABC");
        country.setName("France");
        country.setContinent("Europe");
        country.setRegion("French");
        country.setPopulation(67000000);
        country.setCapital(145);
        countries.add(country);
        Reports.printCountries(countries);
    }

    //************** CAPITAL CITIES UNIT TESTS ***************** Author Del */
    /*
     * Series of unit tests regarding the Capital-based functions as authored by Luke.
     */

    /**
     * Attempt to print an empty Capitals report.
     */
    @Test
    void printCapitalsEmptyTest()
    {
        ArrayList<City> city = new ArrayList<>();
        Reports.printCapitals(city);
    }

    @Test
    void printCapitalsNullTest()
    {
        Reports.printCapitals(null);
    }

    /**
     * Attempt to print a Capitals report with one null entry.
     */
    @Test
    void printCapitalsContainsNullTest()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        Reports.printCities(city);
    }

    /**
     * Create a simple Capital object and attempt to print it.
     */
    @Test
    void printCapitalsTest()
    {
        ArrayList<City> capital = new ArrayList<>();
        City cap = new City();
        cap.setName("Athens");
        cap.setCountry("Greece");
        cap.setDistrict("Central Greece");
        cap.setPopulation(3153000);
        capital.add(cap);
        Reports.printCapitals(capital);
    }

    //************** CITIES UNIT TESTS ***************** Author Colin */
    /*
     * Series of unit tests regarding the Capital-based functions as authored by Luke.
     */


    @Test
    void printCityTestEmpty()
    {
        ArrayList<City> city = new ArrayList<>();
        Reports.printCities(city);
    }

    @Test
    void printCitiesTestNull()
    {
        Reports.printCities(null);
    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        Reports.printCities(city);
    }

    @Test
    void printCitiesTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.setName("France");
        city.setCountry("Europe");
        city.setDistrict("Corse");
        city.setPopulation(100000);
        cities.add(city);
        Reports.printCities(cities);
    }

    //************** LANGUAGE UNIT TESTS ***************** Author Cameron */

    @Test
    void printLanguageDataTestEmpty()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        Reports.printLanguageData(languageData);
    }

    @Test
    void printLanguageDataTestNull()
    {
        Reports.printLanguageData(null);
    }

    @Test
    void printLanguageDataTestContainsNull()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        languageData.add(null);
        Reports.printLanguageData(languageData);
    }

    @Test
    void printLanguageDataTest()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        Languages lang = new Languages();
        lang.setName("France");
        lang.setPopulation((long) 67000000);
        lang.setLanguage("French");
        lang.setNumberOfSpeakers((long) 60000000);
        lang.setPercentageOfWorldPop(10.0);
        languageData.add(lang);
        Reports.printLanguageData(languageData);
    }

    //************** POPULATION UNIT TESTS ***************** Author Luke */

    @Test
    void printPopulationDataCountriesTestEmpty()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        Reports.printPopulationDataCountry(populationData);
    }

    @Test
    void printPopulationDataContinentTestEmpty()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        Reports.printPopulationDataContinent(populationData);
    }

    @Test
    void printPopulationDataRegionTestEmpty()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        Reports.printPopulationDataRegion(populationData);
    }

    @Test
    void printPopulationDataCountryTestNull()
    {
        Reports.printPopulationDataCountry(null);
    }

    @Test
    void printPopulationDataContinentTestNull()
    {
        Reports.printPopulationDataContinent(null);
    }

    @Test
    void printPopulationDataRegionTestNull()
    {
        Reports.printPopulationDataRegion(null);
    }

    @Test
    void printPopulationDataCountriesTestContainsNull()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        populationData.add(null);
        Reports.printPopulationDataCountry(populationData);
    }

    @Test
    void printPopulationDataContinentTestContainsNull()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        populationData.add(null);
        Reports.printPopulationDataContinent(populationData);
    }

    @Test
    void printPopulationDataRegionTestContainsNull()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        populationData.add(null);
        Reports.printPopulationDataRegion(populationData);
    }

    @Test
    void printPopulationDataCountriesTest()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        PopulationData popData = new PopulationData();
        popData.setIdentifier("France");
        popData.setPopulation((long)1000000);
        popData.setPopulationInCities((long)100000);
        popData.setPopulationPercentInCities((double) 65);
        popData.setPopulationNotInCities((long)67000000);
        popData.setPopulationPercentNotInCities((double)14);
        populationData.add(popData);
        Reports.printPopulationDataCountry(populationData);
    }

    @Test
    void printPopulationDataContinentTest()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        PopulationData popData = new PopulationData();
        popData.setIdentifier("France");
        popData.setPopulation((long)1000000);
        popData.setPopulationInCities((long)100000);
        popData.setPopulationPercentInCities((double) 65);
        popData.setPopulationNotInCities((long)67000000);
        popData.setPopulationPercentNotInCities((double)14);
        populationData.add(popData);
        Reports.printPopulationDataContinent(populationData);
    }

    @Test
    void printPopulationDataRegionTest()
    {
        ArrayList<PopulationData> populationData = new ArrayList<>();
        PopulationData popData = new PopulationData();
        popData.setIdentifier("France");
        popData.setPopulation((long)1000000);
        popData.setPopulationInCities((long)100000);
        popData.setPopulationPercentInCities((double) 65);
        popData.setPopulationNotInCities((long)67000000);
        popData.setPopulationPercentNotInCities((double)14);
        populationData.add(popData);
        Reports.printPopulationDataRegion(populationData);
    }
}