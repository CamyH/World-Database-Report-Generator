package com.napier.sem;

import com.napier.sem.db.DbConnection;
import com.napier.sem.sql.Sql;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test File Author: Cameron
 * Date last modified: 10/03/2021
 * Purpose of File: Contain UnitTests for the AdditionalFunctions Reports
 */

public class AdditionalFunctionsTests
{
    static App app;
    static DbConnection db;
    static Connection con;

    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();
        db = new DbConnection();
        // Grab connection to DB
        con = db.getConnection();
    }

    @Test
    void getWorldPopulation()
    {
        Long correctPopulation = 6078749450L;
        Long methodPopulation = Sql.getWorldPopulation(con);
        assertEquals(correctPopulation, methodPopulation);
    }
}

