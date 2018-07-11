package ru.bellintegrator.practice.organization.request;

public class OrganizationUpdateRequest {
	private int id;
    private String name;
    private boolean isActive;
    private String fullName;
    private long inn;
    private long kpp;
    private String adress;
    private String phone;

    public OrganizationUpdateRequest(int id, String name, String fullName, long inn, long kpp, 
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

    public OrganizationUpdateRequest() {

    }

    public int getId() {
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

    public long getInn() {
    	return inn;
    } 

    public long getKpp() {
    	return kpp;
    } 

    public String getAdress() {
    	return adress;
    } 

    public String getPhone() {
    	return phone;
    } 
}