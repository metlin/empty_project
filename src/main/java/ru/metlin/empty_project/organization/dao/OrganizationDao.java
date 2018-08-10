package ru.metlin.empty_project.organization.dao;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;

public interface OrganizationDao {

    void add(Organization organization);

    void update(Organization organization);

    Iterable<Organization> all();

    Organization getById(Long id);
}
