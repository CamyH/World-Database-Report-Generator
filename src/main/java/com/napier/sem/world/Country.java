package com.napier.sem.world;

/**
 * Java class representing a country
 * Date last modified: 06/03/2021
 * Last modified by: Del
 */
public class Country {

    /**
     * Code to Identify country
     */
    private String code;

    /**
     * Name of the country
     */
    private String name;

    /**
     * Name of the continent
     */
    private String continent;

    /**
     * Name of the region
     */
    private String region;

    /**
     * Population of a country
     */
    private int population;

    /**
     * ID for the city which is the capital
     */
    private int capital;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
}
