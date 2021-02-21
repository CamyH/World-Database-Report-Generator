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

    public ArrayList<Country> getLargestPopulationN(Connection con, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "ORDER BY population DESC "
                            + "Limit " + limit;
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

    public ArrayList<Country> getLargestByContinent(Connection con, String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, continent "
                            + "FROM country "
                            + "WHERE continent = '" + continent
                            + "' ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");
                country.continent = rset.getString("continent");

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

    public ArrayList<Country> getLargestByContinentN(Connection con, String continent, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, continent "
                            + "FROM country "
                            + "WHERE continent = '" + continent
                            + "' ORDER BY population DESC "
                            + "Limit " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");
                country.continent = rset.getString("continent");

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

    public void printByContinent(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-10s", "Name", "Population", "Continent"));
        // Loop over all employees in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-10s",
                            country.name, country.population, country.continent);
            System.out.println(country_string);
        }
    }

    public ArrayList<Country> getLargestByRegion(Connection con, String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, region "
                            + "FROM country "
                            + "WHERE region = '" + region
                            + "' ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");
                country.region = rset.getString("region");

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

    public void printByRegion(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-10s", "Name", "Population", "Region"));
        // Loop over all employees in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-10s",
                            country.name, country.population, country.region);
            System.out.println(country_string);
        }
    }
}
