package com.khanhnn.exam_module2.controller;

import com.khanhnn.exam_module2.model.City;
import com.khanhnn.exam_module2.model.Country;
import com.khanhnn.exam_module2.service.CityService;
import com.khanhnn.exam_module2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("/cities")
    public ModelAndView list(@RequestParam("search") Optional<String> search, @PageableDefault(size = 5) Pageable pageable) {
//        Page<City> cities;
        ModelAndView modelAndView = new ModelAndView("city/list");
//
//        if (search.isPresent()) {
//            cities = cityService.findAllByNameContaining(search.get(), pageable);
//        } else {
//            cities = cityService.findAll(pageable);
//        }
//        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

}
