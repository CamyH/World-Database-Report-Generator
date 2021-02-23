package com.napier.sem.sql;

import com.napier.sem.world.City;
import com.napier.sem.world.Country;
import com.napier.sem.world.PopulationData;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 22/02/2021
 * Purpose of class: This class handles the SQL queries to the database.
 * Last modified by: Colin
 */

public class Sql {

    //************** COUNTRIES QUERIES ***************** Author Luke */

    /**
     * Gets all the countries in the world from
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @return All countries and their populations in the world in order of largest to smallest in an ArrayList
     * Report 1 */
    public static ArrayList<Country> getAllCountriesInWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
                            + "FROM country "
                            + "ORDER BY population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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
     * the database and returns the countries object filled with data
     * @param con Holds the connection to the SQL database
     * @param continent Holds the string of a specified continent
     * @return All countries and their populations in a continent in order of largest to smallest in an ArrayList
     * Report 2 */
    public static ArrayList<Country> getAllCountriesInContinent(Connection con, String continent)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
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
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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
     * @param region Holds the string of a specified region
     * @return All countries and their populations in a region in order of largest to smallest in an ArrayList
     * Report 3 */
    public static ArrayList<Country> getAllCountriesByRegion(Connection con, String region)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
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
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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
    public static ArrayList<Country> getTopPopulatedCountriesInWorld(Connection con, int limit)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
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
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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
     * @param continent Holds the string of a specified continent
     * @param limit Holds the a number to limit the amount of results
     * @return The top N countries and their populations in the continent in order of largest to smallest in an ArrayList
     * Report 5 */
    public static ArrayList<Country> getTopPopulatedCountriesInContinent(Connection con, String continent, int limit)
    {
        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
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
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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
     * @param region Holds the string of a specified region
     * @param limit Holds the a number to limit the amount of results
     * @return The top N countries and their populations in the region in order of largest to smallest in an ArrayList
     * report 6 */
    public static ArrayList<Country> getTopPopulatedCountriesInRegion(Connection con, String region, int limit)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
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
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");

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

    //************** CITIES QUERIES ***************** Author Colin */

    /**
     * Gets all the cities in the world from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @return All cities in the world object data
     * Report 7 */
    public static ArrayList<City> getAllCitiesInWorld(Connection con)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the cities in a chosen continent from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param continent Holds the string of a specified continent
     * @return All the cities in a chosen continent object
     * Report 8 */
    public static ArrayList<City> getAllCitiesInContinent(Connection con, String continent)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the cities in a chosen region from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param region Holds the string of a specified region
     * @return all cities in chosen region object
     * Report 9 */
    public static ArrayList<City> getAllCitiesInRegion(Connection con, String region)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the cities in a chosen country from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param country Holds the string of a specified country
     * @return object with all cities in chosen country
     * Report 10 */
    public static ArrayList<City> getAllCitiesInCountry(Connection con, String country)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the cities in a chosen district from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param district Holds the string of a specified district
     * @return all cities in a chosen district object
     * Report 11 */
    public static ArrayList<City> getAllCitiesInDistrict(Connection con, String district)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the N populated cities in the world from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param limit The number of results from the query
     * @return Top populated cities in the world object
     * Report 12 */
    public static ArrayList<City> getTopPopulatedCitiesInWorld(Connection con, int limit)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the N populated cities in a chosen continent from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param limit The number of results from the query
     * @param continent Holds the string of a specified continent
     * @return Top populated cities in a continent object
     * Report 13 */
    public static ArrayList<City> getTopPopulatedCitiesInContinent(Connection con, int limit, String continent)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the N populated cities in a chosen region from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param limit The number of results from the query
     * @param region Holds the string of a specified region
     * @return Top populated cities in a region object
     * Report 14 */
    public static ArrayList<City> getTopPopulatedCitiesInRegion(Connection con, int limit, String region)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the N populated cities in a chosen country from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param limit The number of results from the query
     * @param country Holds the string of a specified country
     * @return Top populated cities in a country object
     * Report 15 */
    public static ArrayList<City> getTopPopulatedCitiesInCountry(Connection con, int limit, String country)
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
            ArrayList<City> cities = new ArrayList<>();
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

    /**
     * Gets all the N populated cities in a chosen district from
     * the database and returns the cities object filled with data.
     * @param con Holds the connection to the SQL database
     * @param limit The number of results from the query
     * @param district Holds the string of a specified district
     * @return Top populated cities in a district object
     * Report 16 */
    public static ArrayList<City> getTopPopulatedCitiesInDistrict(Connection con, int limit, String district)
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
            ArrayList<City> cities = new ArrayList<>();
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

    //************** CAPITAL CITIES QUERIES ***************** Author Del */

    /**
     * Method to return all of the world's capital cities, sorted by descending population
     * @param con Holds the connection to the SQL database
     * @return Name, country and population of every capital city in the world sorted by descending population, or null on error
     */
    public static ArrayList<City> getBiggestWorldCapitals(Connection con){
        try{
            //Create string for statement
            String biggestNCapitalsStatement = ("SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode=country.Code " +
                    "WHERE city.ID = country.Capital " +
                    "ORDER BY city.Population DESC ");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNCapitalsStatement);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestCapitals = new ArrayList<>();
            while (rset.next()){
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestCapitals.add(capital);
            }
            return biggestCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get world's largest capital city details.");
            return null;
        }
    }

    public static ArrayList<City> getBiggestContinentCapitals(Connection con, String cont){
        try {
            //Create string for statement
            String biggestNContCapitalsStatement = ("SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode=country.Code " +
                    "WHERE city.ID = country.Capital AND country.Continent = ? " +
                    "ORDER BY city.Population DESC;");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNContCapitalsStatement);
            preparedStatement.setString(1, cont);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestContCapitals = new ArrayList<>();
            while (rset.next()) {
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestContCapitals.add(capital);
            }
            return biggestContCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent's largest capital city details.");
            return null;
        }
    }

    public static ArrayList<City> getBiggestRegionCapitals(Connection con, String region){
        try {
            //Create string for statement
            String biggestNContCapitalsStatement = ( "SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Region = ?" +
                    "ORDER BY city.Population DESC;");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNContCapitalsStatement);
            preparedStatement.setString(1, region);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestRegionCapitals = new ArrayList<>();
            while (rset.next()) {
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestRegionCapitals.add(capital);
            }
            return biggestRegionCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get region's largest capital city details.");
            return null;
        }
    }

    /**
     * Method to return the most populous n capital cities in the world, sorted by descending population
     * @param con Holds the connection to the SQL database
     * @param n The amount of cities the user wants returned
     * @return The name, country and population of the n most populous capitals in the planet sorted by descending population or null on error
     */
    public static ArrayList<City> getNBiggestWorldCapitals(Connection con, int n){
        try{
            //Create string for statement
            String biggestNCapitalsStatement = ("SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode=country.Code " +
                    "WHERE city.ID = country.Capital " +
                    "ORDER BY city.Population DESC; ");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNCapitalsStatement);
            preparedStatement.setInt(1, n);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestNCapitals = new ArrayList<>();
            while (rset.next()){
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestNCapitals.add(capital);
            }
            return biggestNCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get world's largest capital city details.");
            return null;
        }
    }

    /**
     * Method to return the n most populous capital cities from a single, user-defined continent
     * @param con Holds the connection to the SQL database
     * @param n The amount of cities the user wants returned
     * @param cont The specific continent the user wants the largest capitals of
     * @return The name, country and population of the n most populous capitals in continent cont sorted by descending population, or null on error
     */
    public static ArrayList<City> getNBiggestContinentCapitals(Connection con, int n, String cont){
        try {
            //Create string for statement
            String biggestNContCapitalsStatement = ("SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode=country.Code " +
                    "WHERE city.ID = country.Capital AND country.Continent = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?;");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNContCapitalsStatement);
            preparedStatement.setString(1, cont);
            preparedStatement.setInt(2, n);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestNContCapitals = new ArrayList<>();
            while (rset.next()) {
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestNContCapitals.add(capital);
            }
            return biggestNContCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent's largest capital city details.");
            return null;
        }
    }

    /**
     * Method to return the n most populous capitals in a user-defined region, sorted by descending population
     * @param con Holds the connection to the SQL database
     * @param n Amount of cities user wants data for
     * @param region Region that user wants to narrow search down to
     * @return n most populous capitals in the region sorted by descending population, or null on error
     */
    public static ArrayList<City> getNBiggestRegionCapitals(Connection con, int n, String region){
        try {
            //Create string for statement
            String biggestNContCapitalsStatement = ( "SELECT Name " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Region = ? " +
                    "ORDER BY city.Population DESC" +
                    "LIMIT ?;");
            //Create prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(biggestNContCapitalsStatement);
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, n);
            //Execute
            ResultSet rset = preparedStatement.executeQuery();
            //Extract information from ResultSet
            ArrayList<City> biggestNRegionCapitals = new ArrayList<>();
            while (rset.next()) {
                City capital = new City();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name:);");
                capital.population = rset.getString("city.Population");
                biggestNRegionCapitals.add(capital);
            }
            return biggestNRegionCapitals;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get region's largest capital city details.");
            return null;
        }
    }

    //************** POPULATION QUERIES ***************** Author Cameron */

    /**
     * Method to return a list of population data for each continent
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each continent in an ArrayList,
     * or null if there is an error.
     * Report 23 */
    public static ArrayList<PopulationData> getPopulationDataContinent(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.continent, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.continent; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population data of each continent
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.identifier = rset.getString("country.continent");
                popData.population = getPopulationOfContinent(con, popData.identifier);
                popData.populationInCities = rset.getLong("citiesPopulation");
                popData.populationNotInCities = popData.population - popData.populationInCities;
                allPopulationData.add(popData);
            }
            return allPopulationData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the requested population data.");
            return null;
        }
    }

    /**
     * Method to return a list of population data for each region
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each region in an ArrayList,
     * or null if there is an error.
     * Report 24 */
    public static ArrayList<PopulationData> getPopulationDataRegion(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.region, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.region; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population data of each region
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.identifier = rset.getString("country.region");
                popData.population = getPopulationOfRegion(con, popData.identifier);
                popData.populationInCities = rset.getLong("citiesPopulation");
                popData.populationNotInCities = popData.population - popData.populationInCities;
                allPopulationData.add(popData);
            }
            return allPopulationData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the requested population data.");
            return null;
        }
    }

    /**
     * Method to return a list of population data for each country
     * @param con Holds the connection to the SQL database
     * @return The total population, population living in cities & population not living in cities of each country in an ArrayList,
     * or null if there is an error.
     * Report 25 */
    public static ArrayList<PopulationData> getPopulationDataCountry(Connection con) {
        try {
            // Create SQL statement
            Statement peopleInCitiesStatement = con.createStatement();
            // Create string for SQL statement
            String citiesPopulation = "SELECT country.code, country.name, SUM(city.population) as citiesPopulation " +
                    "FROM city " +
                    "JOIN country ON CountryCode=country.code " +
                    "GROUP BY country.name, country.code; ";
            // Execute SQL statement
            ResultSet rset = peopleInCitiesStatement.executeQuery(citiesPopulation);
            // ArrayList to store all population data required
            ArrayList<PopulationData> allPopulationData = new ArrayList<>();
            // Return population data of each country
            // Check something is returned
            while(rset.next()) {
                PopulationData popData = new PopulationData();
                popData.code = rset.getString("country.code");
                popData.identifier = rset.getString("country.name");
                popData.population = getCountryPopulation(con, popData.code);
                popData.populationInCities = rset.getLong("citiesPopulation");
                popData.populationNotInCities = popData.population - popData.populationInCities;
                allPopulationData.add(popData);
            }
            return allPopulationData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the requested population data.");
            return null;
        }
    }


    //************** ADDITIONAL QUERIES ***************** Author Cameron */

    /**
     * Method to return the population of the world
     * @param con Holds the connection to the SQL server
     * @return The population of the world or null if there is an error
     * Report 26 */
    public static Long getWorldPopulation(Connection con) {
        try {
            // Create SQL statement
            Statement populationStatement = con.createStatement();
            // Create string for SQL statement
            String worldPopulation = "SELECT SUM(population) as worldPopulation " +
                    "FROM country;";
            // Execute SQL statement
            ResultSet rset = populationStatement.executeQuery(worldPopulation);
            // Return world population if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("worldPopulation");
            } else
                return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the world.");
            return null;
        }
    }

    /**
     * Method to return the population of a given continent
     * @param con Holds the connection to the SQL server
     * @param continent Contains the continent to get the population for
     * @return The population of the continent or null if there is an error
     * Report 27 */
    public static Long getPopulationOfContinent(Connection con, String continent) {
        try {
            // Create string for SQL statement
            String continentPopulation = "SELECT SUM(population) as continentPopulation " +
                    "FROM country " +
                    "WHERE continent = ?;";

            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(continentPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, continent);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Return population of continent if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("continentPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the continent " + continent);
            return null;
        }
    }

    /**
     * Method to return the population of a specified region
     * @param con Holds the connection to the SQL server
     * @param region Contains the region to get the population for
     * @return The population of the region or null if there is an error
     * Report 28 */
    public static Long getPopulationOfRegion(Connection con, String region) {
        try {
            // Create string for SQL statement
            String regionPopulation = "SELECT SUM(population) as regionPopulation " +
                    "FROM country " +
                    "WHERE region = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(regionPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, region);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Return population of continent if calculation is valid
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("regionPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to calculate the population of the region " + region);
            return null;
        }
    }

    /**
     * Method to return the population for a specified country
     * @param con Holds the connection to the SQL server
     * @param code Contains the unique country code used to retrieve the correct population
     * @return The population of a country or null if there is an error
     * Report 29 */
    public static Long getCountryPopulation(Connection con, String code) {
        try {
            // Create string for SQL statement
            String countryPopulation = "SELECT name, population " +
                    "FROM country " +
                    "WHERE code = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(countryPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, code);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Return population of specified country + country name
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("population");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the country with the code " + code);
            return null;
        }
    }

    /**
     * Method to return the population of a specified district
     * @param con Holds the connection to the SQL server
     * @param district Contains the district to get the population for
     * @return The population of a given district or null if there is an error
     * Report 30 */
    public static Long getDistrictPopulation(Connection con, String district) {
        try {
            // Create string for SQL statement
            String districtPopulation = "SELECT SUM(population) as districtPopulation " +
                    "FROM city " +
                    "WHERE district = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(districtPopulation);
            // Set SQL statement ? to continent parameter
            preparedStatement.setString(1, district);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Return population of specified district
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("districtPopulation");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of the district.");
            return null;
        }
    }

    /**
     * Method to return the population of a specified city
     * @param con Holds the connection to the SQL server
     * @param cityName Contains the city to get the population for
     * @return The population of a given city or null if there is an error
     * Report 31 */
    public static Long getCityPopulation(Connection con, String cityName) {
        try {
            // Create string for SQL statement
            String cityPopulation = "SELECT population " +
                    "FROM city " +
                    "WHERE name = ?;";
            // Create prepared statement with SQL statement
            PreparedStatement preparedStatement = con.prepareStatement(cityPopulation);
            // Set SQL statement ? to cityName parameter
            preparedStatement.setString(1, cityName);
            // Execute SQL statement
            ResultSet rset = preparedStatement.executeQuery();
            // Return population of specified city
            // Check something is returned
            if(rset.next()) {
                return rset.getLong("population");
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the population of " + cityName);
            return null;
        }
    }


}
