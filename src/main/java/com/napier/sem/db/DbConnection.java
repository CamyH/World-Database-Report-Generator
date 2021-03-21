package com.napier.sem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Project Authors: Colin, Cameron, Luke, Del
 * Date last modified: 20/03/2021
 * Purpose of class: This class handles the connection and disconnection of the database.
 * Last modified by: Cameron
 */

public class DbConnection {


    /**
     * Connection to MySQL database.
     */
    public Connection con = null;


    /**
     * Constructor with automatically connect()
     */
    public DbConnection() {
        this.connect("localhost:33060");
    }


    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
               //Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (Exception ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Connection closed");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Connection getConnection() {
        return this.con;
    }
}
