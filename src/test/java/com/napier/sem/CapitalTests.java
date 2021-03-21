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
    void biggestWorldCapitalsTest(){
        ArrayList<City> biggestWorldCapitals = Sql.getBiggestWorldCapitals(con);
        Assertions.assertNotEquals(null, biggestWorldCapitals);
    }

    @Test
    void biggestContinentCapitalsTest(){
        ArrayList<City> biggestContinentCapitals = Sql.getBiggestContinentCapitals(con, "Europe");
        Assertions.assertNotEquals(null, biggestContinentCapitals);
    }

    @Test
    void biggestRegionCapitalsTest(){
        ArrayList<City> biggestRegionCapitals = Sql.getBiggestRegionCapitals(con, "SEAsia");
        Assertions.assertNotEquals(null, biggestContinentCapitals);
    }
}
