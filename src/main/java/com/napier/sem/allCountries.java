package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class allCountries {


    public ArrayList<Country> getLargestPopulation(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }

    public void printLargest(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s", "Name", "Population"));
        // Loop over all employees in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s",
                            country.name, country.population);
            System.out.println(country_string);
        }
    }
}
