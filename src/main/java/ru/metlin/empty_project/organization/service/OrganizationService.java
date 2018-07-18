package ru.metlin.empty_project.organization.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.model.OrganizationRepository;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.OrganizationResponse;

import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationResponse getOrganization(Long id) throws NotFoundException {
        Organization organization = organizationRepository.findById(id).orElse(null);
        if (organization == null) {
            throw new NotFoundException("No organization with id " + id);
        }
        return new OrganizationResponse(organization);
    }

    public OrganizationResponse createOrganization(SaveOrganizationRequest request) {
        Organization organization = new Organization(request);
        organization = organizationRepository.save(organization);
        return new OrganizationResponse(organization);
    }

    public Organization updateOrganization(UpdateOrganizationRequest request) {
        Organization organization = new Organization(request);
        return organizationRepository.save(organization);
    }

    public Iterable<Organization> getOrganizationList(OrganizationListRequest request) {
        return organizationRepository.findAll();
    }
}
