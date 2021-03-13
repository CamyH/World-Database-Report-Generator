package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.report.Reports;
import com.napier.sem.world.Languages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test File Author: Cameron
 * Date last modified: 13/03/2021
 * Purpose of File: Contain UnitTests for the Language Reports
 */

public class LanguagesTests
{
    static App app;
    static Reports reports;
    static DbConnection db;
    static Connection con;

    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();
        reports = new Reports();
    }

    @Test
    void printLanguageDataTestEmpty()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        Reports.printLanguageData(languageData);
    }

    @Test
    void printLanguageDataTestNull()
    {
        Reports.printLanguageData(null);
    }

    @Test
    void printLanguageDataTestContainsNull()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        languageData.add(null);
        Reports.printLanguageData(languageData);
    }

    @Test
    void printLanguageDataTest()
    {
        ArrayList<Languages> languageData = new ArrayList<>();
        Languages lang = new Languages();
        lang.setName("France");
        lang.setPopulation((long) 67000000);
        lang.setLanguage("French");
        lang.setNumberOfSpeakers((long) 60000000);
        lang.setPercentageOfWorldPop(10.0);
        languageData.add(lang);
        Reports.printLanguageData(languageData);
    }
}

