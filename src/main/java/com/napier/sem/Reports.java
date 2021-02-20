package com.napier.sem;

import java.util.ArrayList;

public class Reports {

    public void printCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "Name", "Country", "District", "Population"));
        // Loop over all employees in the list
        for (City city : cities)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
    }
}
