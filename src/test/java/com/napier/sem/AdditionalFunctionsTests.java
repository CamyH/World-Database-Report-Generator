package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.world.PopulationData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Test File Author: Cameron
 * Date last modified: 13/03/2021
 * Purpose of File: Contain UnitTests for the AdditionalFunctions Reports
 */

public class AdditionalFunctionsTests
{
    static App app;

    @BeforeAll
    static void init()
    {
        // Init new instances of App
        app = new App();
    }

    //************** Continent Tests QUERIES ******************/

    @Test
    void printPopulationDataContinentTestEmpty()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        Reports.printPopulationDataContinent(popData);
    }

    @Test
    void printPopulationDataContinentTestNull()
    {
        Reports.printPopulationDataContinent(null);
    }

    @Test
    void printPopulationDataContinentTestContainsNull()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        popData.add(null);
        Reports.printPopulationDataContinent(popData);
    }

    @Test
    void printPopulationDataContinentTest()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        PopulationData pop = new PopulationData();
        pop.setCode("GBR");
        pop.setIdentifier("UK");
        pop.setPopulation((long) 67000000);
        pop.setPopulationInCities((long) 40200000);
        pop.setPopulationNotInCities((long) 26800000);
        pop.setPopulationPercentInCities(60.0);
        pop.setPopulationPercentNotInCities(40.0);
        popData.add(pop);
        Reports.printPopulationDataContinent(popData);
    }

    //************** Region Tests QUERIES ******************/

    @Test
    void printPopulationDataRegionTestEmpty()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        Reports.printPopulationDataRegion(popData);
    }

    @Test
    void printPopulationDataRegionTestNull()
    {
        Reports.printPopulationDataRegion(null);
    }

    @Test
    void printPopulationDataRegionTestContainsNull()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        popData.add(null);
        Reports.printPopulationDataRegion(popData);
    }

    @Test
    void printPopulationDataRegionTest()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        PopulationData pop = new PopulationData();
        pop.setCode("GBR");
        pop.setIdentifier("UK");
        pop.setPopulation((long) 67000000);
        pop.setPopulationInCities((long) 40200000);
        pop.setPopulationNotInCities((long) 26800000);
        pop.setPopulationPercentInCities(60.0);
        pop.setPopulationPercentNotInCities(40.0);
        popData.add(pop);
        Reports.printPopulationDataRegion(popData);
    }

    //************** Country Tests QUERIES ******************/

    @Test
    void printPopulationDataCountryTestEmpty()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        Reports.printPopulationDataCountry(popData);
    }

    @Test
    void printPopulationDataCountryTestNull()
    {
        Reports.printPopulationDataCountry(null);
    }

    @Test
    void printPopulationDataCountryTestContainsNull()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        popData.add(null);
        Reports.printPopulationDataCountry(popData);
    }

    @Test
    void printPopulationDataCountryTest()
    {
        ArrayList<PopulationData> popData = new ArrayList<>();
        PopulationData pop = new PopulationData();
        pop.setCode("GBR");
        pop.setIdentifier("UK");
        pop.setPopulation((long) 67000000);
        pop.setPopulationInCities((long) 40200000);
        pop.setPopulationNotInCities((long) 26800000);
        pop.setPopulationPercentInCities(60.0);
        pop.setPopulationPercentNotInCities(40.0);
        popData.add(pop);
        Reports.printPopulationDataCountry(popData);
    }
}