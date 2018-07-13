package ru.metlin.empty_project.office;

public class SaveOfficeRequest {
    private String name;
    private Boolean isActive;
    private String adress;
    private String phone;

    public SaveOfficeRequest(String name, Boolean isActive, String adress, String phone) {
        this.name = name;
        this.isActive = isActive;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
