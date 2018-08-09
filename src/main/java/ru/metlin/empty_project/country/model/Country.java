package ru.metlin.empty_project.country.model;

import ru.metlin.empty_project.user.model.User;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Country {

    private Long countryId;
    private String name;
    private Long code;

    @OneToOne
    private User user;
}
