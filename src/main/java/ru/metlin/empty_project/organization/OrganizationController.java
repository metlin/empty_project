package ru.metlin.empty_project.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private String createOrganization(@RequestBody SaveOrganizationRequest request) {
        return "success";
    }

    @PostMapping(value = "/update")
    private String updateOrganization(@RequestBody UpdateOrganizationRequest request) {
        return "success";
    }

    @PostMapping(value = "/list")
    private Iterable<Organization> getOrganizationList(@RequestBody OrganizationListRequest request) {
        return organizationRepository.findAll();
    }
}
