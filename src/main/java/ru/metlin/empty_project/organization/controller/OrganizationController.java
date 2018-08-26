package ru.metlin.empty_project.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.view.GetOrganization;
import ru.metlin.empty_project.organization.view.OrganizationList;
import ru.metlin.empty_project.organization.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/list")
    private List<OrganizationList> getOrganizationList(@RequestBody OrganizationListRequest request) {

        return organizationService.findAll(request);
    }

    @GetMapping(value = "/{id}")
    private GetOrganization getOrganization(@PathVariable Long id) {

        return organizationService.findById(id);
    }

    @PostMapping(value = "/save")
    private SuccessView createOrganization(@RequestBody SaveOrganizationRequest request)  {

        return organizationService.save(request);
    }

    @PostMapping(value = "/update")
    private SuccessView updateOrganization(@RequestBody UpdateOrganizationRequest request) {

        return organizationService.update(request);
    }
}
