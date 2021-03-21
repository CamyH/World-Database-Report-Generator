package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.sql.Sql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * Test file Author: Cameron
 * Date last modified: 20/03/2021
 * Purpose of file: Contain UnitTests for the additional functions reports
 */

public class AdditionalFunctionsTests {
    static App app;

    DbConnection dbc = new DbConnection();
    Connection con = dbc.getConnection();

    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();
    }

    @Test
    void testGetWorldPopulation()
    {
        Long testPop = 6078749450L;
        Long worldPop = Sql.getWorldPopulation(con);
        Assertions.assertEquals(worldPop, testPop, 1);
    }

    @Test
    void testGetPopulationOfContinent()
    {
        Long testPop = 730074600L;
        Long continentPop = Sql.getPopulationOfContinent(con, "Europe");
        Assertions.assertEquals(continentPop, testPop, 1);
    }

    @Test
    void testGetPopulationOfRegion()
    {
        Long testPop = 144674200L;
        Long regionPop = Sql.getPopulationOfRegion(con, "Southern Europe");
        Assertions.assertEquals(regionPop, testPop, 1);
    }

    @Test
    void testGetPopulationOfCountry()
    {
        Long testPop = 59623400L;
        Long countryPop = Sql.getCountryPopulation(con, "GBR");
        Assertions.assertEquals(countryPop, testPop, 1);
    }

    @Test
    void testGetDistrictPopulation()
    {
        Long testPop = 19978543L;
        Long districtPop = Sql.getDistrictPopulation(con, "England");
        Assertions.assertEquals(districtPop, testPop, 1);
    }

    @Test
    void testGetCityPopulation()
    {
        Long testPop = 7285000L;
        Long cityPopulation = Sql.getCityPopulation(con, "London");
        Assertions.assertEquals(cityPopulation, testPop, 1);
    }
}
