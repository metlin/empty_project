package ru.metlin.empty_project.office.request;

public class SaveOfficeRequest {
    private String name;
    private Boolean isActive;
    private String address;
    private String phone;
    private Long orgId;

    public SaveOfficeRequest() {
    }

    public SaveOfficeRequest(String name, Boolean isActive, String address, String phone, Long orgId) {
        this.name = name;
        this.isActive = isActive;
        this.address = address;
        this.phone = phone;
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
