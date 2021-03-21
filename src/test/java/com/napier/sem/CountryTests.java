package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project Authors: Luke
 * Date last modified: 13/03/2021
 * Purpose of class: To test reports country print method.
 * Last modified by: Luke
 */

public class CountryTests {
    static App app;
    static Reports reports;

    DbConnection dbc = new DbConnection();
    Connection con = dbc.getConnection();

    @BeforeAll
    static void init()
    {
        // Init new instances of App & Reports
        app = new App();
        reports = new Reports();

    }

    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Reports.printCountries(countries);
    }

    @Test
    void printCountriesTestNull()
    {
        Reports.printCountries(null);
    }

    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        Reports.printCountries(countries);
    }

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
    @Test
    void getAllCountriesInWorld(){
        ArrayList<Country> check = Sql.getAllCountriesInWorld(con);
        int testPopulation = 1277558000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getAllCountriesInContinent(){
        String continent = "Asia";
        ArrayList<Country> check = Sql.getAllCountriesInContinent(con, continent);
        int testPopulation = 1277558000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);

    }

    @Test
    void getAllCountriesByRegion(){
        String region = "Caribbean";
        ArrayList<Country> check = Sql.getAllCountriesByRegion(con,region);
        int testPopulation = 11201000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }


    @Test
    void getTopPopulatedCountriesInWorld(){
        int testPopulation = 1277558000;
        int limit = 10;
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInWorld(con, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCountriesInContinent(){
        int testPopulation = 146934000;
        int limit = 10;
        String continent = "Europe";
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInContinent(con, continent, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCountriesInRegion(){
        int testPopulation = 11201000;
        int limit = 10;
        String region = "Caribbean";
        ArrayList<Country> check = Sql.getTopPopulatedCountriesInRegion(con, region, limit);
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

}
