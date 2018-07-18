package ru.metlin.empty_project.organization.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.OrganizationResponse;
import ru.metlin.empty_project.organization.service.OrganizationService;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = "/{id}")
    private OrganizationResponse getOrganization(@PathVariable Long id) throws NotFoundException {
        return organizationService.getOrganization(id);
    }

    @PostMapping(value = "/save")
    private OrganizationResponse createOrganization(@RequestBody SaveOrganizationRequest request) {
        return organizationService.createOrganization(request);
    }

    @PostMapping(value = "/update")
    private Organization updateOrganization(@RequestBody UpdateOrganizationRequest request) {
        return organizationService.updateOrganization(request);
    }

    @PostMapping(value = "/list")
    private Iterable<Organization> getOrganizationList(@RequestBody OrganizationListRequest request) {
        return organizationService.getOrganizationList(request);
    }
}
