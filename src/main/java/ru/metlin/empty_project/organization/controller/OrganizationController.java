package ru.metlin.empty_project.organization.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.Response;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.OrganizationResponse;
import ru.metlin.empty_project.organization.service.OrganizationService;
import ru.metlin.empty_project.organization.service.OrganizationServiceImpl;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/list")
    private Iterable<Organization> getOrganizationList(@RequestBody OrganizationListRequest request) {
        return organizationService.findAll();
    }

    @GetMapping(value = "/{id}")
    private Response<Organization> getOrganization(@PathVariable Long id) {
        try {
            return new Response<Organization>(organizationService.findById(id));
        } catch (Exception e) {
            return new Response<Organization>(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    private Response<SuccessView> createOrganization(@RequestBody SaveOrganizationRequest request)  {
        try {
            return new Response<SuccessView>(organizationService.save(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }

    @PostMapping(value = "/update")
    private Response<SuccessView> updateOrganization(@RequestBody UpdateOrganizationRequest request)  {
        try {
            return new Response<SuccessView>(organizationService.update(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }
}
