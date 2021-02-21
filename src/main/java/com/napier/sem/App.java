package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 21/02/2021
 * Purpose of program: To run SQL queries to satisfy the given requirements
 */

public class App
{
    public static void main(String[] args)
    {
        //status update
        System.out.println("Added Con & tidied up tested full - working");

        // Database connection setup
        DbConnection dbc = new DbConnection();
        Connection con = dbc.getConnection();

        // Return all cities in world to cities7 object
        Sql query7 = new Sql();
        ArrayList<City> cities7 = query7.getAllCitiesInWorld(con);

        // Display report from cities7
        Reports report7 = new Reports();
        report7.printCities(cities7);

        // Return all cities in a continent to cities8 object
        Sql query8 = new Sql();
        ArrayList<City> cities8 = query8.getAllCitiesInContinent(con, "Asia");

        // Display report from cities8
        Reports report8 = new Reports();
        report8.printCities(cities8);

        // Return all cities in a region to cities9 object
        Sql query9 = new Sql();
        ArrayList<City> cities9 = query9.getAllCitiesInRegion(con, "Caribbean");

        // Display report from cities9
        Reports report9 = new Reports();
        report9.printCities(cities9);

        // Return all cities in a region to cities10 object
        Sql query10 = new Sql();
        ArrayList<City> cities10 = query10.getAllCitiesInCountry(con, "Brazil");

        // Display report from cities10
        Reports report10 = new Reports();
        report10.printCities(cities10);

        // Return all cities in a district to cities11 object
        Sql query11 = new Sql();
        ArrayList<City> cities11 = query11.getAllCitiesInDistrict(con, "Scotland");

        // Display report from cities11
        Reports report11 = new Reports();
        report11.printCities(cities11);

        // Disconnect from database
        dbc.disconnect();

    }
}