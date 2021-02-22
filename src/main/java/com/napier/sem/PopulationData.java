package com.napier.sem;

public class PopulationData {

    /**
     * Country Code, only used for one of the reports
     */
    public String code;

    /**
     * Continent/Region/Country
     */
    public String identifier;

    /**
     * Total Population
     */
    public Long population;

    /**
     * Population living in cities
     */
    public Long populationInCities;

    /**
     * Population not living in cities
     */
    public Long populationNotInCities;
}
