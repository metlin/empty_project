package ru.metlin.empty_project.country.service;

import ru.metlin.empty_project.country.model.Country;

public interface CountryService {

    Iterable<Country> findAll();
}
