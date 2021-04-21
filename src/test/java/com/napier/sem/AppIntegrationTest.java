package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.Languages;
import com.napier.sem.world.PopulationData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 21/04/2021
 * Purpose of program: Execute a suite of integration tests for the application.
 * Last modified by: Colin
 */
public class AppIntegrationTest {
    static App app;
    static Reports reports;
    private static Connection con;


    /**
     * Prepare for the tests by initialising the App and Reports classes.
     */
    @BeforeAll
    static void init() {
        // Init new instances of App & Reports
        app = new App();
        reports = new Reports();

        DbConnection dbc = new DbConnection();
        con = dbc.getConnection();

    }

    //************** COUNTRY INTEGRATION TESTS ***************** Author Luke//

    /*
     * Series of integration tests regarding the Country-based queries as authored by Luke.
     */

    /**
     *Query the database for all the countries in the world, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getAllCountriesInWorld(){
        ArrayList<Country> check = Sql.getAllCountriesInWorld(con);
        int testPopulation = 1277558000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for all the countries in a continent, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getAllCountriesInContinent(){
        String continent = "Asia";
        ArrayList<Country> check = Sql.getAllCountriesInContinent(con, continent);
        int testPopulation = 1277558000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);

    }

    /**
     *Query the database for all the countries in a region, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getAllCountriesByRegion(){
        String region = "Caribbean";
        ArrayList<Country> check = Sql.getAllCountriesByRegion(con,region);
        int testPopulation = 11201000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous countries in the world, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getTopPopulatedCountriesInWorld(){
        int testPopulation = 1277558000;
        int limit = 10;
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInWorld(con, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous countries in a continent, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getTopPopulatedCountriesInContinent(){
        int testPopulation = 146934000;
        int limit = 10;
        String continent = "Europe";
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInContinent(con, continent, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous countries in a region, sorted by population.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getTopPopulatedCountriesInRegion(){
        int testPopulation = 11201000;
        int limit = 10;
        String region = "Caribbean";
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInRegion(con, region, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    //************** CITIES INTEGRATION TESTS ***************** Author Colin//
    /*
     * Series of integration tests regarding the City-based queries as authored by Colin.
     */

    /**
     *Query the database for all the cities in the world, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getAllCitiesInWorld(){
        ArrayList<City> check = Sql.getAllCitiesInWorld(con);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for all the cities in a continent, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getAllCitiesInContinent(){
        String continent = "Asia";
        ArrayList<City> check = Sql.getAllCitiesInContinent(con,continent);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);

    }

    /**
     *Query the database for all the cities in a region, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getAllCitiesInRegion(){
        String region = "Caribbean";
        ArrayList<City> check = Sql.getAllCitiesInRegion(con,region);
        int testPopulation = 2256000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for all the cities in a country, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getAllCitiesInCountry(){
        String country = "Brazil";
        ArrayList<City> check = Sql.getAllCitiesInCountry(con,country);
        int testPopulation = 9968485;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for all the cities in a district, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getAllCitiesInDistrict(){
        String district = "Scotland";
        ArrayList<City> check = Sql.getAllCitiesInDistrict(con,district);
        int testPopulation = 619680;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous cities in the world, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getTopPopulatedCitiesInWorld(){
        int limit = 10;
        ArrayList<City> check = Sql.getTopPopulatedCitiesInWorld(con,limit);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous cities in a continent, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getTopPopulatedCitiesInContinent(){
        int limit = 10;
        String continent = "Asia";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInContinent(con,limit,continent);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous cities in a region, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getTopPopulatedCitiesInRegion(){
        int limit = 10;
        String region = "Caribbean";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInRegion(con,limit,region);
        int testPopulation = 2256000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous cities in a country, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getTopPopulatedCitiesInCountry(){
        int limit = 10;
        String country = "Brazil";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInCountry(con,limit,country);
        int testPopulation = 9968485;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    /**
     *Query the database for the most populous cities in a district, sorted by population.
     *Confirm successful return by checking population of the first city.
     */
    @Test
    void getTopPopulatedCitiesInDistrict(){
        int limit = 4;
        String district = "Scotland";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInDistrict(con,limit,district);
        int testPopulation = 619680;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    //************** CAPITAL INTEGRATION TESTS ***************** Author Del//
    /*
     * Series of integration tests regarding the Capital-based queries as authored by Del.
     */

    /**
     *Query the database for the most populous cities in a continent, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void biggestWorldCapitalsTest(){
        ArrayList<City> biggestWorldCapitals = Sql.getBiggestWorldCapitals(con);
        Assertions.assertNotEquals(null, biggestWorldCapitals);
        Assertions.assertEquals(9981619, biggestWorldCapitals.get(0).getPopulation());
    }

    /**
    *Query the database for all the capital cities in a continent, sorted by population.
    *Confirm successful return by checking population of the first capital.
    */
    @Test
    void biggestContinentCapitalsTest(){
        ArrayList<City> biggestContinentCapitals = Sql.getBiggestContinentCapitals(con, "Europe");
        Assertions.assertNotEquals(null, biggestContinentCapitals);
        Assertions.assertEquals(8389200, biggestContinentCapitals.get(0).getPopulation());
    }

    /**
     *Query the database for all the capital cities in a region, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void biggestRegionCapitalsTest(){
        ArrayList<City> biggestRegionCapitals = Sql.getBiggestRegionCapitals(con, "Southeast Asia");
        Assertions.assertNotEquals(null, biggestRegionCapitals);
        Assertions.assertEquals(9604900, biggestRegionCapitals.get(0).getPopulation());
    }

    /**
     *Query the database for the 5 biggest capitals in the world, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void biggestNWorldCapitalsTest(){
        ArrayList<City> biggestNWorldCapitals = Sql.getNBiggestWorldCapitals(con, 5);
        Assertions.assertNotEquals(null, biggestNWorldCapitals);
        Assertions.assertEquals(9981619, biggestNWorldCapitals.get(0).getPopulation());
    }

    /**
     *Query the database for the 5 biggest capitals in a continent, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void biggestNContinentCapitalsTest(){
        ArrayList<City> biggestNContinentCapitals = Sql.getNBiggestContinentCapitals(con, 5, "Europe");
        Assertions.assertNotEquals(null, biggestNContinentCapitals);
        Assertions.assertEquals(8389200, biggestNContinentCapitals.get(0).getPopulation());
    }

    /**
     *Query the database for the 5 biggest capitals in a region, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void biggestRegionNCapitalsTest(){
        ArrayList<City> biggestNRegionCapitals = Sql.getNBiggestRegionCapitals(con, 5, "Southeast Asia");
        Assertions.assertNotEquals(null, biggestNRegionCapitals);
        Assertions.assertEquals(9604900, biggestNRegionCapitals.get(0).getPopulation());
    }

    //************** LANGUAGE INTEGRATION TESTS ***************** Author Cameron//
    /*
     * Series of integration tests regarding the Language-based queries as authored by Cameron.
     */

    /**
     *Query the database for the 5 biggest capitals in a continent, sorted by population.
     *Confirm successful return by checking population of the first capital.
     */
    @Test
    void testGetNumberOfLanguageSpeakers()
    {
        Long testPop = 239943734L;
        ArrayList<Languages> languageData = Sql.getNumberOfLanguageSpeakers(con, "English");
        Assertions.assertEquals(languageData.get(0).getNumberOfSpeakers(), testPop, 1);
    }


    //************** POPULATION INTEGRATION TESTS ***************** Author Luke */
    /*
     * Series of integration tests regarding the Population-based queries as authored by Luke.
     */

    /**
     *Query the database for the population data of each country.
     *Confirm successful return by checking population of the first country.
     */
    @Test
    void getPopulationDataCountry(){
        int testPopulation = 2332100;
        ArrayList<PopulationData> check = Sql.getPopulationDataCountry(con);
        Assertions.assertEquals(check.get(0).getPopulationInCities(),testPopulation);
    }

    @Test
    void getPopulationDataContinent(){
        int testPopulation = 697604103;
        ArrayList<PopulationData> check = Sql.getPopulationDataContinent(con);
        Assertions.assertEquals(check.get(0).getPopulationInCities(),testPopulation);
    }

    @Test
    void getPopulationDataRegion(){
        int testPopulation = 207688970;
        ArrayList<PopulationData> check = Sql.getPopulationDataRegion(con);
        Assertions.assertEquals(check.get(0).getPopulationInCities(),testPopulation);
    }

    //************** ADDITIONAL FUNCTIONS INTEGRATION TESTS ***************** Author Cameron */
    /*
     * Series of integration tests regarding additional functions as authored by Cameron.
     */

    /**
     * Query the database for the cumulative population of the whole world.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetWorldPopulation()
    {
        Long testPop = 6078749450L;
        Long worldPop = Sql.getWorldPopulation(con);
        Assertions.assertEquals(worldPop, testPop, 1);
    }

    /**
     * Query the database for the cumulative population of a specific continent.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetPopulationOfContinent()
    {
        Long testPop = 730074600L;
        Long continentPop = Sql.getPopulationOfContinent(con, "Europe");
        Assertions.assertEquals(continentPop, testPop, 1);
    }

    /**
     * Query the database for the cumulative population of a specific region.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetPopulationOfRegion()
    {
        Long testPop = 144674200L;
        Long regionPop = Sql.getPopulationOfRegion(con, "Southern Europe");
        Assertions.assertEquals(regionPop, testPop, 1);
    }

    /**
     * Query the database for the cumulative population of a specific country.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetPopulationOfCountry()
    {
        Long testPop = 59623400L;
        Long countryPop = Sql.getPopulationOfCountry(con, "GBR");
        Assertions.assertEquals(countryPop, testPop, 1);
    }

    /**
     * Query the database for the cumulative population of a specific district.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetDistrictPopulation()
    {
        Long testPop = 19978543L;
        Long districtPop = Sql.getDistrictPopulation(con, "England");
        Assertions.assertEquals(districtPop, testPop, 1);
    }

    /**
     * Query the database for the cumulative population of a specific city.
     * Confirm successful return by comparing returned value to expected correct value.
     */
    @Test
    void testGetCityPopulation()
    {
        Long testPop = 7285000L;
        Long cityPopulation = Sql.getCityPopulation(con, "London");
        Assertions.assertEquals(cityPopulation, testPop, 1);
    }
}