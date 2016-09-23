package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by john.tumminelli on 9/22/16.
 */
public class Country {
    String beginningLetter;
    String abbrev;
    String countryName;









    public String getAbbrev() {
        return abbrev;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getBeginningLetter() {
        return beginningLetter;
    }

    public Country(String beginingLetter, String abbrev, String countryName) {
        this.abbrev = abbrev;
        this.countryName = countryName;
        this.beginningLetter = beginingLetter;






    }
}
