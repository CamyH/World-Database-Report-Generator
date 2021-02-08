package com.napier.sem;

import java.util.Scanner;

public class MenuSelection {

    public static void continentChoice() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Please enter a continent: ");
        String continent = myObj.nextLine();
        System.out.println(continent + " has been selected ");
    }
}

