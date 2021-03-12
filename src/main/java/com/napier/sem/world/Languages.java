package com.napier.sem.world;

/**
 * Java class holding language data
 * Date last modified: 12/03/2021
 * Last modified by: Cameron
 */

public class Languages {
    private String name;

    private Long population;

    private String language;

    private Long percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getPercentage() {
        return percentage;
    }

    public void setPercentage(Long percentage) {
        this.percentage = percentage;
    }
}
