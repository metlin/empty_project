package ru.metlin.empty_project.organization.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.OrganizationResponse;

import javax.transaction.Transactional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOrganizationRequest request) throws Exception {

        if (request.getName() == null) {
            throw new Exception("this organization does not exist");
        }

        Organization organization = new Organization(request);

        return organizationDao.add(organization);
    }

    @Override
    @Transactional
    public SuccessView update(UpdateOrganizationRequest request) throws Exception {

        if (request.getId() == 0) {
            throw new Exception("this organization does not exist");
        }

        if (request.getName() == null) {
            throw new Exception("this organization does not exist");
        }

        if (request.getAddress() == null) {
            throw new Exception("this organization does not exist");
        }

        Organization organization = new Organization(request);

        return organizationDao.add(organization);
    }

    @Override
    @Transactional
    public Iterable<Organization> findAll() {
        return organizationDao.all();
    }

    @Override
    @Transactional
    public Organization findById(Long id) throws Exception {

        if (id == 0) {
            throw new Exception("this organization does not exist");
        }

        return organizationDao.getById(id);
    }
}
