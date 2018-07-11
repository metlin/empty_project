package ru.bellintegrator.practice.organization.view;

import ru.bellintegrator.practice.organization.model.Organization;

public class OrganizationListView {
  
   	private Long id;
    private String name;
    private boolean isActive;
    
    public OrganizationListView() {}

    public OrganizationListView(Organization organization) {
    	this.id = organization.getId();
    	this.name = organization.getName();
    	this.isActive = organization.isActive();
    }

    public OrganizationListView(Long id, String name, boolean isActive) {
    	this.id = id;
    	this.name = name;
    	this.isActive = isActive;
    }

     public Long getId() {
    	return id;
    } 

    public String getName() {
    	return name;
    } 

    public boolean isActive() {
    	return isActive;
    } 
}