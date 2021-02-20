package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new db object from class
        DbConnection dbc = new DbConnection();
        allCountries allC = new allCountries();
        // Connect to database
        dbc.connect();
        //Gets connection value
        Connection con= dbc.getConnection();
        // Get Employee
        ArrayList<Country> largestCountry = allC.getLargestPopulation(con);
        // Display results
        allC.printLargest(largestCountry);

        // Disconnect from database
        dbc.disconnect();

    }
}