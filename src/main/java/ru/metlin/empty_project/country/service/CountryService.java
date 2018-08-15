package ru.metlin.empty_project.country.service;

import ru.metlin.empty_project.country.model.Country;
import ru.metlin.empty_project.country.responce.CountryList;

import java.util.List;

public interface CountryService {

    List<CountryList> findAll() throws Exception;
}
