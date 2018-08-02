package ru.metlin.empty_project.office.model;

import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.organization.model.Organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "active")
    private Boolean isActive;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

 //   @ManyToOne
 //   @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    public Office() {
    }

    public Office(Long id, String name, Boolean isActive, String address, String phone, Long orgId) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.address = address;
        this.phone = phone;
        this.orgId = orgId;
    }

    public Office(SaveOfficeRequest request) {
        this.name = request.getName();
        this.isActive = request.getActive();
        this.address = request.getAddress();
        this.phone = request.getPhone();
        this.orgId = request.getOrgId();
    }

    public Office(UpdateOfficeRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.isActive = request.getActive();
        this.address = request.getAddress();
        this.phone = request.getPhone();
        this.orgId = request.getOrgId();
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
