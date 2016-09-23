package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.printf("Enter your email address: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
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


        creatObject(letterIn);



    }
    static void creatObject(String letterIn){
        File countryAllData = new File("countries.txt");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(countryAllData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileScanner.hasNext()) {
            String scanLine = fileScanner.nextLine();
            String[] abbrevWithCountry = scanLine.split("\\|");
            String abbreviation = abbrevWithCountry[0];
            String countryName = abbrevWithCountry[1];
            String firstLetter = countryName.substring(0,1);
            Country cntryObj = new Country(firstLetter, abbreviation, countryName);
            System.out.printf("%s   %s    %s\n", cntryObj.getBeginningLetter(), cntryObj.getAbbrev(), cntryObj.getCountryName());
        }



    }
}