package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        while (true) {

            mainMenu();

        }


    }
    static void outToText() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the first letter of the countries you like to output: ");
        String letterIn = scanner.nextLine();

        HashMap<String, ArrayList<String>> countryMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> countryArray = new ArrayList<>();

        File countryList = new File("countries.txt");
        Scanner fileScanner = new Scanner(countryList);
        while (fileScanner.hasNext()){
            String scanLine = fileScanner.nextLine();
            String[] abbrevWithCountry =  scanLine.split("\\|");
            String abbreviation = abbrevWithCountry[0];
            String countryName = abbrevWithCountry[1];


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
        System.out.println(countryMap.get(letterIn));
        ArrayList<String> al = countryMap.get(letterIn);
        File f = new File(letterIn + "_countries.txt");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Countries Starting with the letter: " + letterIn.toUpperCase());
            fw.append("\n-------------------------------------\n");
            Iterator<String> itr = al.iterator();
            while (itr.hasNext()){
                String write = itr.next();
                fw.append(write + "\n");
            }
            fw.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("couldn't write to file");
        }

    }
    static void outputCountry(){
        System.out.println("Enter the country name:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        File countryAllData = new File("countries.txt");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(countryAllData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileScanner.hasNextLine()) {
            final String lineFromFile = fileScanner.nextLine();
            if(lineFromFile.contains(input)) {
                // a match!
                String[] abbrevWithCountry =  lineFromFile.split("\\|");
                String abbreviation = abbrevWithCountry[0];
                String countryName = abbrevWithCountry[1];
                System.out.printf("Country Name: %s\n", countryName);
                System.out.printf("Official Country Abbreviation: %s\n", abbreviation);
                Country
                break;
            }
        }

    }

    static void mainMenu () {
        System.out.println("[1] Output countries by first letter to console and .txt file");
        System.out.println("[2] Find a country's official abbreviation code");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("1")){
            try {
                outToText();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (option.equalsIgnoreCase("2")){
            outputCountry();

        }
        else{

        }
    }
}