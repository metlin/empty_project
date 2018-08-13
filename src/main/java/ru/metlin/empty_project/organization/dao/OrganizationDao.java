package ru.metlin.empty_project.organization.dao;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    void add(Organization organization);

    void update(Organization organization);

    List<Organization> all();

    Organization getById(Long id);
}
