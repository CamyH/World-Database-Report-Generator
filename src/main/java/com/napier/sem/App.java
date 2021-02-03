package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        //init main menu
        new MenuChoice().mainMenu();
    }
}