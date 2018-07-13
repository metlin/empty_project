package ru.metlin.empty_project.office;

public class SaveOfficeRequest {
    private String name;
    private Boolean isActive;
    private String address;
    private String phone;

    public SaveOfficeRequest(String name, Boolean isActive, String address, String phone) {
        this.name = name;
        this.isActive = isActive;
        this.address = address;
        this.phone = phone;
    }

    public SaveOfficeRequest() {
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
}
