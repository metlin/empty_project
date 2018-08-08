package ru.metlin.empty_project.organization.model;

import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "org_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "active")
    private Boolean isActive;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "kpp")
    private Long kpp;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Office> officeList;

    public Organization(Long id, String name, Boolean isActive, String fullName, Long inn, Long kpp, String address, String phone) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
    }

    public Organization() {}

    public Organization(SaveOrganizationRequest request) {
        this.name = request.getName();
        this.isActive = request.getActive();
        this.fullName = request.getFullName();
        this.inn = request.getInn();
        this.kpp = request.getKpp();
        this.address = request.getAddress();
        this.phone = request.getPhone();
    }

    public Organization(UpdateOrganizationRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.isActive = request.getActive();
        this.fullName = request.getFullName();
        this.inn = request.getInn();
        this.kpp = request.getKpp();
        this.address = request.getAddress();
        this.phone = request.getPhone();
    }

    @Override
    public String toString() {
        return  id + " "  + name  + " "  + isActive + "  "  + address + "  " + phone;
    }

    public void addOffice(Office office) {

        if (officeList == null) {
            officeList = new ArrayList<>();
        }

        getOfficeList().add(office);

    //    office.setOrganization(this);
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
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

    public List<Office> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
    }
}
