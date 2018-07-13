package ru.metlin.empty_project.organization;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.web.bind.annotation.*;
import ru.metlin.empty_project.organization.Organization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @GetMapping(value = "/{id}")
    private Organization getOrganizaion(@PathVariable Long id) {
        Organization organization = new Organization();
        organization.setId(id);
        organization.setName("Garprom");
        return organization;
    }

    @PostMapping(value = "/save")
    private String createOrganization(@RequestBody Organization request) {
        return "success";
    }

    @PostMapping(value = "/update")
    private String updateOrganization(@RequestBody Organization request) {
        return "success";
    }

    @PostMapping(value = "/list")
    private List<Organization> getOrganizationList(@RequestBody Organization request) {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        organization.setActive(true);

        return Arrays.asList(organization, organization, organization);
    }
}
