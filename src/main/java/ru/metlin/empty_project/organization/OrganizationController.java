package ru.metlin.empty_project.organization;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @GetMapping(value = "/{id}")
    private Organization getOrganizaion(@PathVariable Long id) {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        return organization;
    }

    @PostMapping(value = "/save")
    private Organization createOrganization(@RequestBody Organization request) {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        return organization;
    }

    @PostMapping(value = "/update")
    private Organization updateOrganization(@RequestBody Organization request) {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        return organization;
    }

    @GetMapping(value = "/list")
    private List<Organization> getOrganizationList() {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        return Arrays.asList(organization, organization, organization);
    }
}
