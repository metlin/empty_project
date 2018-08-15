package ru.metlin.empty_project.country.dao;

import ru.metlin.empty_project.country.model.Country;

import java.util.List;

public interface CountryDao {

    List<Country> all();

    Country getById(Long id);
}
