package ru.metlin.empty_project.office;

public class OfficeListRequest {
    private Long orgid;
    private String name;
    private Boolean isActive;
    private String phone;

    public OfficeListRequest(Long orgid, String name, Boolean isActive, String phone) {
        this.orgid = orgid;
        this.name = name;
        this.isActive = isActive;
        this.phone = phone;
    }

    public OfficeListRequest() {
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
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
