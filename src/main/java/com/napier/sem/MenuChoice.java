package com.napier.sem;

public class MenuChoice {

    //Function for root menu
    public void mainMenu() {
        Menu menu = new Menu();

        menu.setTitle("*** Global Reports ***");
        menu.addItem(new MenuItem("Countries", this, "countries"));
        menu.addItem(new MenuItem("Cities" ,this,"cities"));
        menu.addItem(new MenuItem("Capital Cities",this,"capitalCities"));
        menu.addItem(new MenuItem("Population",this,"population"));
        menu.execute();
    }

    //Countries menu choice
    public void countries() {
        Menu menu = new Menu();

        menu.setTitle("*** Countries Reports ***");
        menu.addItem(new MenuItem("All countries in world, largest first population",this,"allCountriesInWorld"));
        menu.addItem(new MenuItem("All countries in a continent",this,"allCountriesInContinent"));
        menu.execute();
    }


    public void cities() {

    }

    public void capitalCities() {


    }

    public void population() {


    }

    public void allCountriesInWorld() {


    }

    public void allCountriesInContinent() {

        MenuSelection.continentChoice();
    }





}

