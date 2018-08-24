package ru.metlin.empty_project.organization.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.Response;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.exception.EmptyListException;
import ru.metlin.empty_project.exception.InvalidNameException;
import ru.metlin.empty_project.exception.InvalidValueException;
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

    public boolean validationByName(String name) {
        if (name == null) {
            throw new NullPointerException("The organization does not exist");
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'z' ) {
                throw new InvalidNameException("The name cannot contain symbols");
            }
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                throw new InvalidNameException("The name must not contain spaces");
            }
        }

        return true;
    }

    public boolean validationByInnAndKpp(Long inn, Long kpp) {

        if (inn < 1000000000L || inn > 9999999999L) {
            throw new InvalidValueException("inn must contain 10 digits");
        }

        if (kpp < 100000000L || kpp > 999999999L) {
            throw new InvalidValueException("kpp must contain 9 digits");
        }

        return true;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOrganizationRequest request) {
        validationByName(request.getName());
        validationByInnAndKpp(request.getInn(), request.getKpp());

        Organization organization = new Organization(request);

        organizationDao.add(organization);

        return new SuccessView();
    }

    @Override
    @Transactional
    public SuccessView update(UpdateOrganizationRequest request) {

        if (request.getId() == 0) {
            throw new InvalidValueException("The organization does not exist");
        }

        validationByName(request.getName());
        validationByInnAndKpp(request.getInn(), request.getKpp());

        Organization organization = new Organization(request);

        organizationDao.update(organization);
        
        return new SuccessView();
    }

    @Override
    @Transactional
    public Response<List<OrganizationList>> findAll(OrganizationListRequest request) {

        List<Organization> orgList = organizationDao.all(request);

        if (orgList.isEmpty()) {
            throw new EmptyListException("OrganizationList does not exist");
        }

        List<OrganizationList> orgListResponse = new ArrayList<>();

        for (int i = 0; i < orgList.size(); i++) {
            orgListResponse.add(new OrganizationList(orgList.get(i)));
        }

        return new Response<>(orgListResponse);
    }

    @Override
    @Transactional
    public GetOrganization findById(Long id) {

        if (id < 1) {
            throw new InvalidValueException("ID greater than 0");
        }

        Organization organization = organizationDao.getById(id);

        if (organization == null) {
            throw new NullPointerException("The organization does not exist");
        }

        return new GetOrganization(organization);
    }
}
