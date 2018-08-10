package ru.metlin.empty_project.office.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.dao.OrganizationDaoImpl;
import ru.metlin.empty_project.organization.model.Organization;

import javax.transaction.Transactional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganizationDao orgDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao orgDao) {
        this.officeDao = officeDao;
        this.orgDao = orgDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOfficeRequest request) throws Exception {

        if (request.getOrgId() == 0) {
            throw new Exception("this office does not exist");
        }

        String officeName = request.getName();

        for (int i = 0; i < officeName.length(); i++) {
            if (officeName.charAt(i) == ' ') {
                throw new Exception("the name must not contain spaces");
            }
        }

        if (officeName.length() < 2 ) {
            throw new Exception("short office name");
        }

        String officePhone = request.getPhone();

        for (int i = 0; i < officePhone.length(); i++) {
            if (officePhone.charAt(i) < '0' || officePhone.charAt(i) > '9' ) {
                throw new Exception("phone number cannot contain letters");
            }
        }

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new Exception("Office should have an organization");
        }

        Office office = new Office(request);
        office.setOrganization(organization);
        organization.addOffice(office);

        return officeDao.add(office);
    }

    @Override
    @Transactional
    public SuccessView update(UpdateOfficeRequest request) throws Exception {

        if (request.getId() == 0) {
            throw new Exception("this office does not exist");
        }

        if (request.getOrgId() == 0) {
            throw new Exception("this office does not exist");
        }

        String officeName = request.getName();

        for (int i = 0; i < officeName.length(); i++) {
            if (officeName.charAt(i) == ' ') {
                throw new Exception("the name must not contain spaces");
            }
        }

        if (officeName.length() < 2 ) {
            throw new Exception("short office name");
        }

        String officePhone = request.getPhone();

        for (int i = 0; i < officePhone.length(); i++) {
            if (officePhone.charAt(i) < '0' || officePhone.charAt(i) > '9' ) {
                throw new Exception("phone number cannot contain letters");
            }
        }

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new Exception("Office should have an organization");
        }

        Office office = new Office(request);
        office.setOrganization(organization);

        return officeDao.update(office);
    }

    @Override
    @Transactional
    public Iterable<Office> findAll() {

       // тут фильтр

        return officeDao.all();
    }

    @Override
    @Transactional
    public Office findById(Long id) throws Exception {

        if (id < 1) {
            throw new Exception("id greater than 0");
        }

        Office office = officeDao.getById(id);

        if (office == null) {
            throw new Exception("this office does not exist");
        }

        return officeDao.getById(id);
    }
}
