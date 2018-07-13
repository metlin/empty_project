package ru.metlin.empty_project.organization;

public class OrganizationListRequest {
    private Long inn;
    private String name;
    private Boolean isActive;

    public OrganizationListRequest(Long inn, String name, Boolean isActive) {
        this.inn = inn;
        this.name = name;
        this.isActive = isActive;
    }

    public OrganizationListRequest() {
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
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
