package ru.metlin.empty_project.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.country.dao.CountryDao;
import ru.metlin.empty_project.country.model.Country;
import ru.metlin.empty_project.country.view.CountryList;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryDao countryDao;

    @Autowired
    CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public List<CountryList> findAll() {
        List<Country> countryList = countryDao.all();

        if (countryList == null) {
            throw new NullPointerException("Country list does not exist");
        }

        List<CountryList> countryListResponse = new ArrayList<>();

        for (int i = 0; i < countryList.size(); i++) {
            countryListResponse.add(new CountryList(countryList.get(i)));
        }

        return countryListResponse;
    }
}

