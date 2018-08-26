package ru.metlin.empty_project.organization.service;

import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.view.GetOrganization;
import ru.metlin.empty_project.organization.view.OrganizationList;

import java.util.List;

public interface OrganizationService {

    SuccessView save(SaveOrganizationRequest request);

    SuccessView update(UpdateOrganizationRequest request);

    List<OrganizationList> findAll(OrganizationListRequest request);

    GetOrganization findById(Long id);
}
