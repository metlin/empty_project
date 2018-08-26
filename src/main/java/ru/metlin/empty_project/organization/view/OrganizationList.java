package ru.metlin.empty_project.organization.view;

import ru.metlin.empty_project.organization.model.Organization;

public class OrganizationList {

    private Long id;
    private String name;
    private Boolean isActive;


    public OrganizationList(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.isActive = organization.getActive();
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
}
