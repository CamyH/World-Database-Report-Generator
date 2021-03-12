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
 * Date last modified: 12/03/2021
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
        db = new DbConnection();
        // Grab connection to DB
        con = db.getConnection();
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
}

