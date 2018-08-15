package ru.metlin.empty_project.office.response;

import ru.metlin.empty_project.office.model.Office;

public class GetOffice {

    private Long id;
    private String name;
    private Boolean isActive;
    private String address;
    private String phone;
    private Long orgId;

    public GetOffice(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.isActive = office.getActive();
        this.address = office.getAddress();
        this.phone = office.getPhone();
        this.orgId = office.getOrganization().getId();
    }

    public GetOffice() {
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
