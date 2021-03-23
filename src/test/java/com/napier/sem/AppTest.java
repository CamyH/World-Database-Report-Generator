package com.napier.sem;

import com.napier.sem.report.Reports;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.Languages;
import com.napier.sem.world.PopulationData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        Reports.printCountries(countries);
    }

    @Test
    void printCountriesTestNull() {
        Reports.printCountries(null);
    }

    @Test
    void printCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        Reports.printCountries(countries);
    }

    @Test
    void printCountriesTest() {
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

    @Test
    void printCapitalsEmptyTest()
    {
        ArrayList<City> city = new ArrayList<>();
        Reports.printCapitals(city);
    }

    @Test
    void printCapitalsContainsNullTest()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        Reports.printCities(city);
    }


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