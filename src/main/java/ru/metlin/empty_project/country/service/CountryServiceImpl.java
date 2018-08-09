package ru.metlin.empty_project.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.country.dao.CountryDao;
import ru.metlin.empty_project.country.model.Country;

import javax.transaction.Transactional;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryDao countryDao;

    @Autowired
    CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public Iterable<Country> findAll() {
        return countryDao.all();
    }
}

