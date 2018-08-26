package ru.metlin.empty_project.country.service;

import ru.metlin.empty_project.country.view.CountryList;

import java.util.List;

public interface CountryService {

    List<CountryList> findAll();
}
