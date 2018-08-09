package ru.metlin.empty_project.country.model;

import ru.metlin.empty_project.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country_name", length = 50, nullable = false)
    private String name;

    @Column(name = "country_code", length = 3, nullable = false)
    private Long code;

    @OneToOne(mappedBy = "country")
    private User user;

    public Country(Long countryId, String name, Long code) {
        this.countryId = countryId;
        this.name = name;
        this.code = code;
    }

    public Country() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
