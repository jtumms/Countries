package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> countryMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> countryArray = new ArrayList<>();

        /* Call importData method to scan .txt file,
        * make primitive array of country names and abbrev.,
        * create objects and create arraylist, add Country names to arraylist*/

        importData(countryArray);

        /*parse country names for frst letter, make first letter key and then parse
        * country name by letter and add as value to hashmap */

        populateData(countryArray, countryMap);


        //System.out.println(countryArray);

        //System.out.println(countryMap);


    }
    static void importData(ArrayList<String> countryArray) throws FileNotFoundException {
        File countryList = new File("countries.txt");
        Scanner fileScanner = new Scanner(countryList);

        while (fileScanner.hasNext()){
            String scanLine = fileScanner.nextLine();
            String[] abbrevWithCountry =  scanLine.split("\\|");
            String abbreviation = abbrevWithCountry[0];
            String countryName = abbrevWithCountry[1];
            Country country = new Country(abbreviation, countryName);
            System.out.println(country.abbrev + " " + country.countryName);

            countryArray.add(countryName);


        }


    }
    static void populateData(ArrayList<String> countryArray, HashMap<String, ArrayList<String>> countryMap){
        for (String eachLine : countryArray){
            String firstLetter = String.valueOf(eachLine.charAt(0));
            countryMap.put(firstLetter, new ArrayList<>());
        }
        for (String eachLine : countryArray) {
            String firstLetter = String.valueOf(eachLine.charAt(0));
            ArrayList<String> arr = countryMap.get(firstLetter);
            arr.add(eachLine);
        }
    }


}
