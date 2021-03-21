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
 * Date last modified: 17/03/2021
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

    @Test
    void getAllCitiesInContinent(){
        String continent = "Asia";
        ArrayList<City> check = Sql.getAllCitiesInContinent(con,continent);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);

    }

    @Test
    void getAllCitiesInRegion(){
        String region = "Caribbean";
        ArrayList<City> check = Sql.getAllCitiesInRegion(con,region);
        int testPopulation = 2256000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getAllCitiesInCountry(){
        String country = "Brazil";
        ArrayList<City> check = Sql.getAllCitiesInCountry(con,country);
        int testPopulation = 9968485;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getAllCitiesInDistrict(){
        String district = "Scotland";
        ArrayList<City> check = Sql.getAllCitiesInDistrict(con,district);
        int testPopulation = 619680;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCitiesInWorld(){
        int limit = 10;
        ArrayList<City> check = Sql.getTopPopulatedCitiesInWorld(con,limit);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCitiesInContinent(){
        int limit = 10;
        String continent = "Asia";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInContinent(con,limit,continent);
        int testPopulation = 10500000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCitiesInRegion(){
        int limit = 10;
        String region = "Caribbean";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInRegion(con,limit,region);
        int testPopulation = 2256000;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCitiesInCountry(){
        int limit = 10;
        String country = "Brazil";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInCountry(con,limit,country);
        int testPopulation = 9968485;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }

    @Test
    void getTopPopulatedCitiesInDistrict(){
        int limit = 4;
        String district = "Scotland";
        ArrayList<City> check = Sql.getTopPopulatedCitiesInDistrict(con,limit,district);
        int testPopulation = 619680;
        Assertions.assertEquals(check.get(0).getPopulation(),testPopulation);
    }


}
