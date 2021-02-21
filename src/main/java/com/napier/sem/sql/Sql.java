package com.napier.sem.sql;

import com.napier.sem.world.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 21/02/2021
 * Purpose of class: This class handles the SQL queries to the database.
 */

public class Sql {

    /** Gets all the cities in the world from
     * the database and returns the cities object filled with data.
     */
    public ArrayList<City> getAllCitiesInWorld(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code order by city.population DESC;";

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

    /** Gets all the cities in a chosen continent from
     * the database and returns the cities object filled with data.
     */
    public ArrayList<City> getAllCitiesInContinent(Connection con, String continent)
    {

        try
        {
            // Create string for SQL statement
            String strSelect ="SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.continent = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, continent);

            // Execute SQL statement - swapped stmt variable out for preparedStatement
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city continent details");
            return null;
        }
    }

    /** Gets all the cities in a chosen region from
     * the database and returns the cities object filled with data.
     */
    public ArrayList<City> getAllCitiesInRegion(Connection con, String region)
    {

        try
        {
            String strSelect ="SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.region = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, region);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city region details");
            return null;
        }
    }

    /** Gets all the cities in a chosen country from
     * the database and returns the cities object filled with data.
     */
    public ArrayList<City> getAllCitiesInCountry(Connection con, String country)
    {

        try
        {
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.name = ? order by city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, country);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city country details");
            return null;
        }
    }

    /** Gets all the cities in a chosen district from
     * the database and returns the cities object filled with data.
     */
    public ArrayList<City> getAllCitiesInDistrict(Connection con, String district)
    {

        try
        {
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE district = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city district details");
            return null;
        }
    }

    /* Working on next
    public ArrayList<City> getTopPopulatedCitiesInWorld(Connection con, int number)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to limit parameter
            preparedStatement.setInt(1, number);

            // Execute SQL statement
            //ResultSet rset = stmt.executeQuery(strSelect);
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get top cities in world details");
            return null;
        }
    }

    public ArrayList<City> getTopPopulatedCitiesInContinent(Connection con, String continent)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE district = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);

            // Execute SQL statement
            //ResultSet rset = stmt.executeQuery(strSelect);
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city district details");
            return null;
        }
    }

    public ArrayList<City> getTopPopulatedCitiesInRegion(Connection con, String region)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE district = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);

            // Execute SQL statement
            //ResultSet rset = stmt.executeQuery(strSelect);
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city district details");
            return null;
        }
    }

    public ArrayList<City> getTopPopulatedCitiesInCountry(Connection con, String country)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE district = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);

            // Execute SQL statement
            //ResultSet rset = stmt.executeQuery(strSelect);
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city district details");
            return null;
        }
    }

    public ArrayList<City> getTopPopulatedCitiesInDistrict(Connection con, String district)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE district = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);

            // Execute SQL statement
            //ResultSet rset = stmt.executeQuery(strSelect);
            ResultSet rset = preparedStatement.executeQuery();

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
            System.out.println("Failed to get city district details");
            return null;
        }
    }


     */
}
