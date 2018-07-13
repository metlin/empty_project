package ru.metlin.empty_project.office;

public class UpdateOfficeRequest {
    private Long id;
    private String name;
    private Boolean isActive;
    private String adress;
    private String phone;

    public UpdateOfficeRequest(Long id, String name, Boolean isActive, String adress, String phone) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.adress = adress;
        this.phone = phone;
    }

    public UpdateOfficeRequest() {
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
