package ru.metlin.empty_project.organization.dao;

import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;

import java.util.List;

public interface OrganizationDao {

    void add(Organization organization);

    void update(Organization organization);

    List<Organization> all(OrganizationListRequest organization);

    Organization getById(Long id);
}
