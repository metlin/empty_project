package ru.metlin.empty_project.organization.service;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.GetOrganization;
import ru.metlin.empty_project.organization.response.OrganizationList;

import java.util.List;

public interface OrganizationService {

    SuccessView save(SaveOrganizationRequest request);

    SuccessView update(UpdateOrganizationRequest request);

    List<OrganizationList> findAll(OrganizationListRequest request);

    GetOrganization findById(Long id);
}
