package ru.metlin.empty_project.office.response;

import ru.metlin.empty_project.office.model.Office;

public class OfficeList {

    private Long id;
    private String name;
    private Boolean isActive;

    public OfficeList(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.isActive = office.getActive();
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
