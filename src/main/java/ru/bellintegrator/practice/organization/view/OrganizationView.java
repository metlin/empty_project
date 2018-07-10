package ru.bellintegrator.practice.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {
  
   	private int id;

    private String name;

    private boolean isActive;

    public OrganizationView(int id, String name, boolean isActive) {
    	this.id = id;
    	this.name = name;
    	this.isActive = isActive;
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

/*    @Override
    public String toString() {
        return "{id: " + id + ";name: " + name + ";isActive " + isActive + "}";
    } */
}