package ru.metlin.empty_project.organization.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.OrganizationResponse;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;
    private OfficeDao officeDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, OfficeDao officeDao) {
        this.organizationDao = organizationDao;
        this.officeDao = officeDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOrganizationRequest request) throws Exception {

        if (request.getName() == null) {
            throw new Exception("this organization does not exist");
        }

        String orgName = request.getName();

        for (int i = 0; i < orgName.length(); i++) {
            if (orgName.charAt(i) < 'A' || orgName.charAt(i) > 'z' ) {
                throw new Exception("the name cannot contain symbols");
            }
        }

        if (request.getInn() < 1000000000L || request.getInn() > 9999999999L) {
            throw new Exception("inn must contain 10 digits");
        }

        if (request.getKpp() < 100000000L || request.getKpp() > 999999999L) {
            throw new Exception("kpp must contain 9 digits");
        }

        Organization organization = new Organization(request);

        organizationDao.add(organization);

        return new SuccessView();
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

        String orgName = request.getName();

        for (int i = 0; i < orgName.length(); i++) {
            if (orgName.charAt(i) < 'A' || orgName.charAt(i) > 'z' ) {
                throw new Exception("the name cannot contain symbols");
            }
        }

        if (request.getInn() < 1000000000L || request.getInn() > 9999999999L) {
            throw new Exception("inn must contain 10 digits");
        }

        if (request.getKpp() < 100000000L || request.getKpp() > 999999999L) {
            throw new Exception("kpp must contain 9 digits");
        }

        Organization organization = new Organization(request);

        organizationDao.update(organization);
        
        return new SuccessView();
    }

    @Override
    @Transactional
    public Iterable<Organization> findAll() {
        return organizationDao.all();
    }

    @Override
    @Transactional
    public Organization findById(Long id) throws Exception {

        if (id < 1) {
            throw new Exception("id greater than 0");
        }

        Organization  organization = organizationDao.getById(id);

        if (organization == null) {
            throw new Exception("this organization does not exist");
        }

        return organizationDao.getById(id);
    }
}
