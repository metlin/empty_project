package ru.bellintegrator.practice.organization.request;

public class OrganizationListRequest {
	private int inn;
	private String name;
	private boolean isActive;

	OrganizationListRequest(int inn, String name, boolean isActive) {
    	this.inn = inn;
    	this.name = name;
    	this.isActive = isActive;
	}

	OrganizationListRequest() {
		
	}

	public int getInn() {
    	return inn;
    } 

    public String getName() {
    	return name;
    } 

    public boolean isActive() {
    	return isActive;
    }  
}