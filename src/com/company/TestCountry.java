package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by john.tumminelli on 9/25/16.
 */

public class TestCountry {

    @Test
    public void countryTest() throws Exception {
        Country country = new Country("v", "VA", "virginia");
        country.beginningLetter = "v";
        country.abbrev = "us";
        country.countryName = "USA";



    }

}