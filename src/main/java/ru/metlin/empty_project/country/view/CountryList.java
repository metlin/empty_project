package ru.metlin.empty_project.country.view;

import ru.metlin.empty_project.country.model.Country;

public class CountryList {

    private Long id;
    private Long code;
    private String name;

    public CountryList(Country country) {
        this.id = country.getCountryId();
        this.code = country.getCode();
        this.name = country.getName();
    }

    public CountryList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
