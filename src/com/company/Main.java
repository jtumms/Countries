package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        mainMenu();


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
    static void creatObject(){
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
    static void mainMenu ()  {
        System.out.println("[1] Output countries by first letter to console and .txt file");
        System.out.println("[2] Find a country's official abbreviation code");
        StringBuffer str = new StringBuffer();                              //Code used from http://stackoverflow.com/questions/30564519/java-read-key-from-console-without-press-enter-key
        char c;
        Reader reader = new InputStreamReader(System.in);
        try {
            while ((c=(char)reader.read())!='1') {
                if ((c=(char)reader.read()) == '2'){
                    creatObject();
                }
                str.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outToText();
        } catch (FileNotFoundException e) {

        }


    }
}