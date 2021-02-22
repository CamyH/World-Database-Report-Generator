package com.napier.sem.sql;

import com.napier.sem.world.City;
import com.napier.sem.world.Country;

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

    /**
     * Gets all the countries in the world from
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @return All countries and their populations in the world in order of largest to smallest in an ArrayList
     * Report 1 */
    public ArrayList<Country> getAllCountriesInWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "ORDER BY population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
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

    /**
     * Gets all the countries in a continet from
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @param continent Holds the string of a specified continent
     * @return All countries and their populations in a continent in order of largest to smallest in an ArrayList
     * Report 2 */
    public ArrayList<Country> getAllCountriesInContinent(Connection con, String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, continent "
                            + "FROM country "
                            + "WHERE continent = ? "
                            + "ORDER BY population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Extract country information
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

    /**
     * Gets all the countries in a continent from
     * the databse and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @param region Holds the of a specified region
     * @return All countries and their populations in a region in order of largest to smallest in an ArrayList
     * Report 3 */
    public ArrayList<Country> getAllCountriesByRegion(Connection con, String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, region "
                            + "FROM country "
                            + "WHERE region = ? "
                            + "ORDER BY population DESC;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, region);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Extract country information
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

    /**
     * Gets top populated countries in the world from
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @param limit Holds the a number to limit the amount of results
     * @return The top N countries and their populations in the world in order of largest to smallest in an ArrayList
     * Report 4 */
    public ArrayList<Country> getTopPopulatedCountriesInWorld(Connection con, int limit)
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
                            + "Limit ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to limit parameter
            preparedStatement.setInt(1, limit);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Extract country information
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

    /**
     * Gets top populated countries in a continent from
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @param continent
     * @param limit Holds the a number to limit the amount of results
     * @return The top N countries and their populations in the continent in order of largest to smallest in an ArrayList
     * Report 5 */
    public ArrayList<Country> getTopPopulatedCountriesInContinent(Connection con, String continent, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, continent "
                            + "FROM country "
                            + "WHERE continent = ? "
                            + "ORDER BY population DESC "
                            + "Limit ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, continent);
            preparedStatement.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Extract country information
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

    /**
     * Gets top populated countries in a region from
     * the database and returns the countries object fulled with data
     * @param con Holds the connection to the SQL database
     * @param region
     * @param limit Holds the a number to limit the amount of results
     * @return The top N countries and their populations in the region in order of largest to smallest in an ArrayList
     * report 6 */
    public ArrayList<Country> getTopPopulatedCountriesInRegion(Connection con, String region, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population, region "
                            + "FROM country "
                            + "WHERE region = ? "
                            + "ORDER BY population DESC "
                            + "Limit ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Extract country information
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

    /** Gets all the cities in the world from
     * the database and returns the cities object filled with data.
     * Report 7 */
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
     * Report 8 */
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
     * Report 9 */
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
     * Report 10 */
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
     * Report 11 */
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

    /** Gets all the N populated cities in the world from
     * the database and returns the cities object filled with data.
     * Report 12 */
    public ArrayList<City> getTopPopulatedCitiesInWorld(Connection con, int limit)
    {

        try
        {

            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to limit parameter
            preparedStatement.setInt(1, limit);

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
            System.out.println("Failed to get top N cities in world details");
            return null;
        }
    }

    /** Gets all the N populated cities in a chosen continent from
     * the database and returns the cities object filled with data.
     * Report 13 */
    public ArrayList<City> getTopPopulatedCitiesInContinent(Connection con, int limit, String continent)
    {

        try
        {

            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE continent = ? ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, continent);
            preparedStatement.setInt(2, limit);

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
            System.out.println("Failed to get city continent details");
            return null;
        }
    }

    /** Gets all the N populated cities in a chosen region from
     * the database and returns the cities object filled with data.
     * Report 14 */
    public ArrayList<City> getTopPopulatedCitiesInRegion(Connection con, int limit, String region)
    {

        try
        {
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE region = ? ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, limit);

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

    /** Gets all the N populated cities in a chosen country from
     * the database and returns the cities object filled with data.
     * Report 15 */
    public ArrayList<City> getTopPopulatedCitiesInCountry(Connection con, int limit, String country)
    {

        try
        {

            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE country.name = ? ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, country);
            preparedStatement.setInt(2, limit);

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

    /** Gets all the N populated cities in a chosen district from
     * the database and returns the cities object filled with data.
     * Report 16 */
    public ArrayList<City> getTopPopulatedCitiesInDistrict(Connection con, int limit, String district)
    {

        try
        {
            // Create string for SQL statement
            String strSelect = "SELECT city.name, country.name, city.district, city.population FROM city JOIN country ON CountryCode=code WHERE city.district = ? ORDER BY city.population DESC LIMIT ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            //set sql statement ? to continent parameter
            preparedStatement.setString(1, district);
            preparedStatement.setInt(2, limit);

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


}
