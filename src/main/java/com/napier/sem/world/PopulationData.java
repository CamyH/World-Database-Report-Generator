package com.napier.sem.world;

/**
 * Java class holding general population data
 * Date last modified: 06/03/2021
 * Last modified by: Del
 */

public class PopulationData {

    /**
     * Country Code, only used for one of the reports
     */
    private String code;

    /**
     * Continent/Region/Country
     */
    private String identifier;

    /**
     * Total Population
     */
    private Long population;

    /**
     * Population living in cities
     */
    private Long populationInCities;

    /**
     * Population living in cities %
     */
    private Double populationPercentInCities;

    /**
     * Population not living in cities
     */
    private Long populationNotInCities;

    /**
     * Population not living in cities %
     */
    private Double populationPercentNotInCities;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getPopulationInCities() {
        return populationInCities;
    }

    public void setPopulationInCities(Long populationInCities) {
        this.populationInCities = populationInCities;
    }

    public Double getPopulationPercentInCities() {
        return populationPercentInCities;
    }

    public void setPopulationPercentInCities(Double populationPercentInCities) {
        this.populationPercentInCities = populationPercentInCities;
    }

    public Long getPopulationNotInCities() {
        return populationNotInCities;
    }

    public void setPopulationNotInCities(Long populationNotInCities) {
        this.populationNotInCities = populationNotInCities;
    }

    public Double getPopulationPercentNotInCities() {
        return populationPercentNotInCities;
    }

    public void setPopulationPercentNotInCities(Double populationPercentNotInCities) {
        this.populationPercentNotInCities = populationPercentNotInCities;
    }
}
