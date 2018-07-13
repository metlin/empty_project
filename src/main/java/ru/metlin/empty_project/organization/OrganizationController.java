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
        organization.setId(id);
        organization.setName("Garprom");
        organization.setFullName("PAO Garprom");
        organization.setActive(true);
        organization.setAdress("RF, Moskow");
        organization.setInn(43434343123L);
        organization.setKpp(456784224L);
        organization.setPhone("8(495)123-45-67");
        return organization;
    }

    @PostMapping(value = "/save")
    private String createOrganization(@RequestBody SaveOrganizationRequest request) {
        return "success";
    }

    @PostMapping(value = "/update")
    private String updateOrganization(@RequestBody UpdateOrganizationRequest request) {
        return "success";
    }

    @PostMapping(value = "/list")
    private List<Organization> getOrganizationList(@RequestBody OrganizationListRequest request) {
        Organization organization = new Organization();
        organization.setId(42L);
        organization.setName("Garprom");
        organization.setActive(true);

        return Arrays.asList(organization, organization, organization);
    }
}
