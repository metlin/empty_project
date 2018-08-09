package ru.metlin.empty_project.country.dao;

import ru.metlin.empty_project.country.model.Country;

public interface CountryDao {

    Iterable<Country> all();
}
