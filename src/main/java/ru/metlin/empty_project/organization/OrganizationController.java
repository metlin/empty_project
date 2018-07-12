package ru.metlin.empty_project.organization;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @GetMapping(value = "/{id}")
    private String getOrganizaion() {
        return "getOrganizaion";
    }

    @PostMapping(value = "/save")
    private String createOrganization() {
        return "createOrganization";
    }

    @PostMapping(value = "/update")
    private String updateOrganization() {
        return "updateOrganization";
    }

    @GetMapping(value = "/list")
    private String getOrganizationList() {
        return "getOrganizationList";
    }
}
