package ru.metlin.empty_project.organization.service;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;

public interface OrganizationService {

    SuccessView save(SaveOrganizationRequest request) throws Exception;

    SuccessView update(UpdateOrganizationRequest request) throws Exception;

    Iterable<Organization> findAll();

    Organization findById(Long id) throws Exception;
}
