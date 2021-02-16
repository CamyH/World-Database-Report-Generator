package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static void main(String[] args)
    {
        // Create new db object from class
        DbConnection dbc = new DbConnection();
        // Connect to database
        dbc.connect();
        //Gets connection value
        Connection con= dbc.getConnection();
        // Get Employee
        Country country = getCountry(con, "ABW");
        // Display results
        displayCountry(country);

        // Disconnect from database
        dbc.disconnect();

    }



    public static Country getCountry(Connection con, String code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent "
                            + "FROM country "
                            + "LIMIT 100 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public static void displayCountry(Country country)
    {
        if (country != null)
        {
            System.out.println(
                    country.code + " "
                            + country.name + " "
                            + country.continent + "\n");
        }
    }


}