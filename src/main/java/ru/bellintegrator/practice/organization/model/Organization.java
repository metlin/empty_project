package ru.bellintegrator.practice.organization.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {
  
   	private Long id;
    private String name;
    private boolean isActive;
    private String fullName;
    private Long inn;
    private Long kpp;
    private String adress;
    private String phone;


    public Organization(Long id, String name, boolean isActive) {
    	this.id = id;
    	this.name = name;
    	this.isActive = isActive;
    }

    public Organization(Long id, String name, String fullName, Long inn, Long kpp, 
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

    public Organization() {

    }

    public Long getId() {
    	return id;
    } 

    public String getName() {
    	return name;
    } 

    @JsonProperty(value="isActive")
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