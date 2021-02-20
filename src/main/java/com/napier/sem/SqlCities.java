package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/02/2021
 * Purpose of class: This class handles the SQL queries to the database.
 */

public class SqlCities {


    public ArrayList<City> getAllCities()
    {
        try
        {

            DbConnection dbc = new DbConnection();
            dbc.connect();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT city.name, country.name, city.district, city.population "
                                + "FROM city city JOIN country country "
                                + "ON CountryCode=code order by city.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.name");
                city.country = rset.getString("country.name");
                city.district = rset.getString("city.district");
                city.population = rset.getString("city.population");
                cities.add(city);
            }
            System.out.println("Query Complete, object return next");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
}
