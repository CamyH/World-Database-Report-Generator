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
 * Project Authors: Del
 * Date last modified: 21/03/2021
 * Purpose of class: Test method for Capital Cities queries
 * Last modified by: Del
 */

public class CapitalTests {
    // world 9981619 europe 8389200 SEAsia 9604900
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
    void biggestWorldCapitalsTest(){
        ArrayList<City> biggestWorldCapitals = Sql.getBiggestWorldCapitals(con);
        Assertions.assertNotEquals(null, biggestWorldCapitals);
        Assertions.assertEquals(9981619, biggestWorldCapitals.get(0).getPopulation());
    }

    @Test
    void biggestContinentCapitalsTest(){
        ArrayList<City> biggestContinentCapitals = Sql.getBiggestContinentCapitals(con, "Europe");
        Assertions.assertNotEquals(null, biggestContinentCapitals);
        Assertions.assertEquals(8389200, biggestContinentCapitals.get(0).getPopulation());
    }

    @Test
    void biggestRegionCapitalsTest(){
        ArrayList<City> biggestRegionCapitals = Sql.getBiggestRegionCapitals(con, "Southeast Asia");
        Assertions.assertNotEquals(null, biggestRegionCapitals);
        Assertions.assertEquals(9604900, biggestRegionCapitals.get(0).getPopulation());
    }

    @Test
    void biggestNWorldCapitalsTest(){
        ArrayList<City> biggestNWorldCapitals = Sql.getNBiggestWorldCapitals(con, 5);
        Assertions.assertNotEquals(null, biggestNWorldCapitals);
        Assertions.assertEquals(9981619, biggestNWorldCapitals.get(0).getPopulation());
    }

    @Test
    void biggestNContinentCapitalsTest(){
        ArrayList<City> biggestNContinentCapitals = Sql.getNBiggestContinentCapitals(con, 5, "Europe");
        Assertions.assertNotEquals(null, biggestNContinentCapitals);
        Assertions.assertEquals(8389200, biggestNContinentCapitals.get(0).getPopulation());
    }

    @Test
    void biggestRegionNCapitalsTest(){
        ArrayList<City> biggestNRegionCapitals = Sql.getNBiggestRegionCapitals(con, 5, "Southeast Asia");
        Assertions.assertNotEquals(null, biggestNRegionCapitals);
        Assertions.assertEquals(9604900, biggestNRegionCapitals.get(0).getPopulation());
    }
}
