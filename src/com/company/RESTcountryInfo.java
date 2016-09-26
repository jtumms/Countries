package com.company;

import jodd.json.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by john.tumminelli on 9/25/16.
 */
public class RESTcountryInfo {

    public RESTcountryInfo() {
    }

    static Capital parseRestAPI () throws MalformedURLException {
        String inline = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Country Code: ");
        String countryCode = (scanner.nextLine()).toUpperCase();
        String countryURL = String.format("http://www.geognos.com/api/en/countries/info/%s.json", countryCode);
        URL url = new URL(countryURL);
        try {
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();           //create a http connect object
            conn.setRequestMethod("GET");                                               //set request method to GET
            conn.connect();                                                             //connect
        int responseCode = conn.getResponseCode();
            if (responseCode != 200){
                throw new RuntimeException("HttpResponseCode:" + responseCode);
            }
            else {
                Scanner scan = new Scanner(url.openStream());                   // open the url stream
                while (scan.hasNext()) {                                         //scan line by line and store as string
                    inline += scan.nextLine();
                }
                System.out.println("\nJSON Response in String format");
                System.out.println(inline);
//            close the stream of the url read
                scan.close();
            }
            Capital capital = new Capital();

            JsonParser parser = new JsonParser();
            return parser.parse(inline, Capital.class);




        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }



    }









    public static void main(String[] args) {

    }
}
