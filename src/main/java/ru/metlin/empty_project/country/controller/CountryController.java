package ru.metlin.empty_project.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.country.service.CountryService;
import ru.metlin.empty_project.country.view.CountryList;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(value = "/countries")
    private List<CountryList> getCountriesList() {

        return countryService.findAll();
    }
}
