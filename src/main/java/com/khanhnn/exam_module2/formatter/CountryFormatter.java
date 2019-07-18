package com.khanhnn.exam_module2.formatter;

import com.khanhnn.exam_module2.model.Country;
import com.khanhnn.exam_module2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter <Country> {

    @Autowired
    private CountryService countryService;

    @Autowired
    public void CountryService(CountryService countryService) {
        this.countryService= countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
