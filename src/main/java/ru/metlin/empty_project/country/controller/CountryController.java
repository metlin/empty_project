package ru.metlin.empty_project.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.country.service.CountryService;

@RestController
@RequestMapping(value = "/api")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

  /*  @PostMapping(value = "/countries")
    private Response<List<CountryList>> getCountriesList() {
        try {
            return new Response<List<CountryList>>(countryService.findAll());
        } catch (Exception e) {
            return new Response<List<CountryList>>(e.getMessage());
        }
    } */
}
