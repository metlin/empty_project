package ru.metlin.empty_project.organization.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.model.Organization;
import ru.metlin.empty_project.organization.request.OrganizationListRequest;
import ru.metlin.empty_project.organization.request.SaveOrganizationRequest;
import ru.metlin.empty_project.organization.request.UpdateOrganizationRequest;
import ru.metlin.empty_project.organization.response.GetOrganization;
import ru.metlin.empty_project.organization.response.OrganizationList;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public OrganizationServiceImpl() {
    }

    public boolean validationByName(String name) throws Exception {
        if (name == null) {
            throw new Exception("this organization does not exist");
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'z' ) {
                throw new Exception("the name cannot contain symbols");
            }
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                throw new Exception("the name must not contain spaces");
            }
        }

        return true;
    }

    public void validationByInnAndKpp(Long inn, Long kpp) throws Exception {
        if (inn < 1000000000L || inn > 9999999999L) {
            throw new Exception("inn must contain 10 digits");
        }

        if (kpp < 100000000L || kpp > 999999999L) {
            throw new Exception("kpp must contain 9 digits");
        }
    }

    @Override
    @Transactional
    public SuccessView save(SaveOrganizationRequest request) throws Exception {
        validationByName(request.getName());
        validationByInnAndKpp(request.getInn(), request.getKpp());

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

        validationByName(request.getName());
        validationByInnAndKpp(request.getInn(), request.getKpp());

        Organization organization = new Organization(request);

        organizationDao.update(organization);
        
        return new SuccessView();
    }

    @Override
    @Transactional
    public List<OrganizationList> findAll(OrganizationListRequest request) throws Exception {

        List<Organization> orgList = organizationDao.all(request);

        if (orgList.isEmpty()) {
            throw new Exception("organizationList does not exist");
        }

        List<OrganizationList> orgListResponse = new ArrayList<>();

        for (int i = 0; i < orgList.size(); i++) {
            orgListResponse.add(new OrganizationList(orgList.get(i)));
        }

        return orgListResponse;
    }

    @Override
    @Transactional
    public GetOrganization findById(Long id) throws Exception {

        if (id < 1) {
            throw new Exception("id greater than 0");
        }

        Organization organization = organizationDao.getById(id);

        if (organization == null) {
            throw new Exception("this organization does not exist");
        }

        return new GetOrganization(organization);
    }
}
