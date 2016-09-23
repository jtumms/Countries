package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        importData();

        populateMap();

        System.out.println(countryMap);

    }

    public static void importData() throws FileNotFoundException {
        ArrayList<String> countryArray = new ArrayList<>();
        File countryList = new File("countries.txt");
        Scanner fileScanner = new Scanner(countryList);
        while (fileScanner.hasNext()){
            String scanLine = fileScanner.nextLine();
            String[] abbrevWithCountry =  scanLine.split("\\|");
            String abbreviation = abbrevWithCountry[0];
            String countryName = abbrevWithCountry[1];
            Country country = new Country(abbreviation, countryName);
            countryArray.add(countryName);

        }


    }

    public static void populateMap() {
        HashMap<String, ArrayList<String>> countryMap = new HashMap<>();
        for (String eachLine : countryArray){
            String firstLetter = String.valueOf(eachLine.charAt(0));
            countryMap.put(firstLetter, new ArrayList<>());

        }
        for (String eachLine : countryArray){
            String firstLetter = String.valueOf(eachLine.charAt(0));
            ArrayList<String> arr = countryMap.get(firstLetter);
            arr.add(eachLine);
        }
    }

}
