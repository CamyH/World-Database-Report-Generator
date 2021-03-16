package com.napier.sem;

import com.napier.sem.report.Reports;
import com.napier.sem.world.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Project Authors: Luke
 * Date last modified: 13/03/2021
 * Purpose of class: To test reports country print method.
 * Last modified by: Luke
 */

public class CountryTests {
    static App app;
    static Reports reports;


    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();
        reports = new Reports();
    }

    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Reports.printCountries(countries);
    }

    @Test
    void printCountriesTestNull()
    {
        Reports.printCountries(null);
    }

    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        Reports.printCountries(countries);
    }

    @Test
    void printCountriesTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setCode("ABC");
        country.setName("France");
        country.setContinent("Europe");
        country.setRegion("French");
        country.setPopulation(67000000);
        country.setCapital(145);
        countries.add(country);
        Reports.printCountries(countries);
    }
}
