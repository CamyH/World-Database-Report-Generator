package com.napier.sem;

import java.sql.Connection;

public class App
{
    public static void main(String[] args)
    {

        // Create new db object from class
        DbConnection dbc = new DbConnection();

        // Connect to database
        dbc.connect();

        //Gets connection value
        Connection con = dbc.getConnection();

        // Disconnect from database
        dbc.disconnect();

    }





}