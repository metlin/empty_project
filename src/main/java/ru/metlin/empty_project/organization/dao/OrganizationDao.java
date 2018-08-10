package ru.metlin.empty_project.organization.dao;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;

public interface OrganizationDao {

    SuccessView add(Organization organization);

    SuccessView update(Organization organization);

    Iterable<Organization> all();

    Organization getById(Long id);
}
