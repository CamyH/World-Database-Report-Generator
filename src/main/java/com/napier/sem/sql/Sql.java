package com.napier.sem.sql;

import com.napier.sem.world.City;
import com.napier.sem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/02/2021
 * Purpose of class: This class handles the SQL queries to the database.
 */

public class Sql {


    public ArrayList<City> getAllCitiesInWorld()
    {
        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

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

    public ArrayList<City> getAllCitiesInContinent(String continent)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            //String strSelect ="SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.continent = '"+continent+"' ORDER BY city.population DESC;";
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

    public ArrayList<City> getAllCitiesInRegion(String region)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect ="SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.region = ? ORDER BY city.population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, region);


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
            System.out.println("Failed to get city region details");
            return null;
        }
    }

    public ArrayList<City> getAllCitiesInCountry(String country)
    {

        try
        {

            DbConnection dbc = new DbConnection();
            Connection con = dbc.getConnection();

            // Create an SQL statement
            //Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.name = ? order by city.population DESC;";


            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, country);

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
            System.out.println("Failed to get city country details");
            return null;
        }
    }

    public ArrayList<City> getAllCitiesInDistrict(String district)
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
}
