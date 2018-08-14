package ru.metlin.empty_project.organization.response;

import ru.metlin.empty_project.organization.model.Organization;

import java.util.List;

public class OrganizationList {   //переделать

    private Long id;
    private String name;
    private Boolean isActive;

    private List<OrganizationList> responseList;



 /*   public OrganizationList(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.isActive = organization.getActive();
    } */

    public OrganizationList(List<Organization> orgList) {


    }

    public OrganizationList() {
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

    public List<OrganizationList> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<OrganizationList> responseList) {
        this.responseList = responseList;
    }
}
