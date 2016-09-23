package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> countryMap = new HashMap<>();

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


        for (String eachLine : countryArray){
            String firstLetter = String.valueOf(eachLine.charAt(0));
            countryMap.put(firstLetter, new ArrayList<>());
        }
        for (String eachLine : countryArray) {
            String firstLetter = String.valueOf(eachLine.charAt(0));
            ArrayList<String> arr = countryMap.get(firstLetter);
            arr.add(eachLine);
        }


        System.out.println(countryMap);
    }

}
