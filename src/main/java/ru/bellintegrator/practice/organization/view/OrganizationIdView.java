package ru.bellintegrator.practice.organization.view;

import ru.bellintegrator.practice.organization.model.Organization;

public class OrganizationIdView {
  
   	private Long id;
    private String name;
    private boolean isActive;
    private String fullName;
    private Long inn;
    private Long kpp;
    private String adress;
    private String phone;

    public OrganizationIdView(Organization organization) {
    	this.id = organization.getId();
    	this.name = organization.getName();
    	this.fullName = organization.getfullName();
    	this.inn = organization.getInn();
    	this.kpp = organization.getKpp();
    	this.adress = organization.getAdress();
    	this.phone = organization.getPhone();
    	this.isActive = organization.isActive();
    }

    public OrganizationIdView(Long id, String name, String fullName, Long inn, Long kpp, 
    	String adress, String phone, boolean isActive) {
    	this.id = id;
    	this.name = name;
    	this.fullName = fullName;
    	this.inn = inn;
    	this.kpp = kpp;
    	this.adress = adress;
    	this.phone = phone;
    	this.isActive = isActive;
    }

    public OrganizationIdView() {}

    public Long getId() {
    	return id;
    } 

    public String getName() {
    	return name;
    } 

    public boolean isActive() {
    	return isActive;
    } 

    public String getfullName() {
    	return fullName;
    } 

    public Long getInn() {
    	return inn;
    } 

    public Long getKpp() {
    	return kpp;
    } 

    public String getAdress() {
    	return adress;
    } 

    public String getPhone() {
    	return phone;
    } 
}