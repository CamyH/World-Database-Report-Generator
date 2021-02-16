package com.napier.sem;

public class App
{
    public static void main(String[] args)
    {

        // Create new db object from class
        DbConnection dbc = new DbConnection();

        // Connect to database
        dbc.connect();

        // Disconnect from database
        dbc.disconnect();

    }





}