package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Luke
 * Date last modified: 13/03/2021
 * Purpose of class: To test reports populationData print method.
 * Last modified by: Luke
 */

public class PopulationDataTests{
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
}
