package ru.metlin.empty_project.organization.responce;

import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.model.OrganizationRepository;

public class GetOrganizationResponce {

    private Long id;
    private String name;
    private Boolean isActive;
    private String fullName;
    private Long inn;
    private Long kpp;
    private String address;
    private String phone;

    public GetOrganizationResponce(Long id, String name, Boolean isActive, String fullName, Long inn, Long kpp,
                                   String address, String phone) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
    }

    public GetOrganizationResponce() {
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
