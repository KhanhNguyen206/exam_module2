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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        Page<City> cities;
        ModelAndView modelAndView = new ModelAndView("city/list");

        if (search.isPresent()) {
            cities = cityService.findAllByNameContaining(search.get(), pageable);
        } else {
            cities = cityService.findAll(pageable);
        }
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public String saveCustomer(@Valid @ModelAttribute("city") City city
            , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAllAttributes(bindingResult.getModel());
            return "city/create";
        } else {
            cityService.save(city);
            model.addAttribute("city", city);
            return "redirect:/cities";
        }
    }

    @GetMapping("/view-city/{id}")
    public ModelAndView view(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/view");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

}
