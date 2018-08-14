package ru.metlin.empty_project.office.request;

public class OfficeListRequest {
    private Long orgId;
    private String name;
    private Boolean isActive;
    private String phone;

    public OfficeListRequest(Long orgId, String name, Boolean isActive, String phone) {
        this.orgId = orgId;
        this.name = name;
        this.isActive = isActive;
        this.phone = phone;
    }

    public OfficeListRequest() {
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
