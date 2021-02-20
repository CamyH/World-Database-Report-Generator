package com.napier.sem;

import com.napier.sem.report.Reports;
import com.napier.sem.sql.Sql;
import com.napier.sem.world.City;

import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/02/2021
 * Purpose of program: To run SQL queries to satisfy the given requirements
 */

public class App
{
    public static void main(String[] args)
    {
        System.out.println("4th Query - Fixed query");
        //SqlCities query7 = new SqlCities();
        //ArrayList<City> cities7 = query7.getAllCitiesInWorld();

        //Reports report7 = new Reports();
        //report7.printCities(cities7);

        //SqlCities query8 = new SqlCities();
        //ArrayList<City> cities8 = query8.getAllCitiesInContinent("Asia");

        //Reports report8 = new Reports();
        //report8.printCities(cities8);

        //SqlCities query9 = new SqlCities();
        //ArrayList<City> cities9 = query9.getAllCitiesInRegion("Caribbean");

        //Reports report9 = new Reports();
        //report9.printCities(cities9);


        //SqlCities query10 = new SqlCities();
        //ArrayList<City> cities10 = query10.getAllCitiesInCountry("Brazil");

        //Reports report10 = new Reports();
        //report10.printCities(cities10);

        Sql query11 = new Sql();
        ArrayList<City> cities11 = query11.getAllCitiesInDistrict("Scotland");

        Reports report11 = new Reports();
        report11.printCities(cities11);


        // Create new db object from class
        //DbConnection dbc = new DbConnection();

        // Connect to database
        //dbc.connect();

        // Gets connection value
        //Connection con = dbc.getConnection();

        // Disconnect from database
        //dbc.disconnect();

    }
}