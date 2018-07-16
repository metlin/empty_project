package ru.metlin.empty_project.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping(value = "/{id}")
    private Optional<Organization> getOrganization(@PathVariable Long id) {
        return organizationRepository.findById(id);
    }

    @PostMapping(value = "/save")
    private Organization createOrganization(@RequestBody SaveOrganizationRequest request) {
        Organization organization = new Organization(request);
        return organizationRepository.save(organization);
    }

    @PostMapping(value = "/update")
    private Organization updateOrganization(@RequestBody UpdateOrganizationRequest request) {
        Organization organization = new Organization(request);
        return organizationRepository.save(organization);
    }

    @PostMapping(value = "/list")
    private Iterable<Organization> getOrganizationList(@RequestBody OrganizationListRequest request) {
        return organizationRepository.findAll();
    }
}
