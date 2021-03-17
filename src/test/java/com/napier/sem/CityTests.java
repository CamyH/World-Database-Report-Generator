package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.util.ArrayList;


/**
 * Project Authors: Colin
 * Date last modified: 16/03/2021
 * Purpose of class: To test methods of city classes.
 * Last modified by: Colin
 */

public class CityTests {

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
    void getAllCitiesInWorld(){

       ArrayList<City> check = Sql.getAllCitiesInWorld(con);
       int testPopulation = 10500000;
       Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);

    }
/*
    @Test
    void getAllCitiesInWorldEmpty(){

    }
    @Test
    void getAllCitiesInWorldTest(){

    }
    @Test
    void getAllCitiesInContinent(){}
    @Test
    void getAllCitiesInRegion(){}
    @Test
    void getAllCitiesInCountry(){}
    @Test
    void getAllCitiesInDistrict(){}
    @Test
    void getTopPopulatedCitiesInWorld(){}
    @Test
    void getTopPopulatedCitiesInContinent(){}
    @Test
    void getTopPopulatedCitiesInRegion(){}
    @Test
    void getTopPopulatedCitiesInCountry(){}
    @Test
    void getTopPopulatedCitiesInDistrict(){}
*/

}
