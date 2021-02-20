package com.napier.sem;

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
        System.out.println("First SQL Query - New columns report 30");
        SqlCities query7 = new SqlCities();

        ArrayList<City> cities = query7.getAllCities();
        Reports report7 = new Reports();
        report7.printCities(cities);


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