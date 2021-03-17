package com.napier.sem.world;

/**
 * Java class representing a city
 * Date last modified: 06/03/2021
 * Last modified by: Del
 */


public class City {

    /**
     * name variable for city object
     */
    private String name;

    /**
     * country variable for city object
     */
    private String country;

    /**
     * district variable for city object
     */
    private String district;

    /**
     * population variable for city object
     */
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
