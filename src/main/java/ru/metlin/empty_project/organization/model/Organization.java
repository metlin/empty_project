package ru.metlin.empty_project.organization.model;

import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private Boolean isActive;
    private String fullName;
    private Long inn;
    private Long kpp;
    private String address;
    private String phone;

    public Organization(Long id, String name, Boolean isActive, String fullName, Long inn, Long kpp, String address, String phone) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
    }

    public Organization() {}

    public Organization(SaveOrganizationRequest request) {
        this.name = request.getName();
        this.isActive = request.getActive();
        this.fullName = request.getFullName();
        this.inn = request.getInn();
        this.kpp = request.getKpp();
        this.address = request.getAddress();
        this.phone = request.getPhone();
    }

    public Organization(UpdateOrganizationRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.isActive = request.getActive();
        this.fullName = request.getFullName();
        this.inn = request.getInn();
        this.kpp = request.getKpp();
        this.address = request.getAddress();
        this.phone = request.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
