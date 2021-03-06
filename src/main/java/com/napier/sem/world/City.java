package com.napier.sem.world;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/02/2021
 * Purpose of class: This class is the city class with the required columns.
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
    private String population;

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

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
