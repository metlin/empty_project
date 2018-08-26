package ru.metlin.empty_project.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.exception.EmptyListException;
import ru.metlin.empty_project.exception.InvalidNameException;
import ru.metlin.empty_project.exception.InvalidPhoneNumberException;
import ru.metlin.empty_project.exception.InvalidValueException;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.view.GetOffice;
import ru.metlin.empty_project.office.view.OfficeList;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.model.Organization;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OfficeServiceImpl implements OfficeService {

    private OfficeDao officeDao;
    private OrganizationDao orgDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao orgDao) {
        this.officeDao = officeDao;
        this.orgDao = orgDao;
    }

    public OfficeServiceImpl() {
    }

    public boolean validationByName(String name) {
        if (name == null) {
            throw new NullPointerException("The office does not exist");
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

    public boolean validationByPhone(String phone) {

        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }

        return true;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOfficeRequest request) {

        if (request.getOrgId() == 0) {
            throw new InvalidValueException("The office does not exist");
        }

        validationByName(request.getName());
        validationByPhone(request.getPhone());

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new NullPointerException("Office should have an organization");
        }

        Office office = new Office(request);

        office.setOrganization(organization);
        organization.addOffice(office);

        officeDao.add(office);

        return new SuccessView();
    }

    @Override
    @Transactional
    public SuccessView update(UpdateOfficeRequest request) {

        if (request.getId() == 0) {
            throw new InvalidValueException("The office does not exist");
        }

        if (request.getOrgId() == 0) {
            throw new InvalidValueException("The office does not exist");
        }

        validationByName(request.getName());
        validationByPhone(request.getPhone());

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new NullPointerException("Office should have an organization");
        }

        Office office = new Office(request);

        office.setOrganization(organization);

        officeDao.update(office);

        return new SuccessView();
    }

    @Override
    @Transactional
    public List<OfficeList> findAll(OfficeListRequest request) {

        List<Office> officeList = officeDao.all(request);

        if (officeList.isEmpty()) {
            throw new EmptyListException("OfficeList does not exist (invalid org_id)");
        }

        List<OfficeList> officeListResponse = new ArrayList<>();

        for (int i = 0; i < officeList.size(); i++) {
            officeListResponse.add(new OfficeList(officeList.get(i)));
        }

        return officeListResponse;
    }

    @Override
    @Transactional
    public GetOffice findById(Long id) {

        if (id < 1) {
            throw new InvalidValueException("ID greater than 0");
        }

        Office office = officeDao.getById(id);

        if (office == null) {
            throw new NullPointerException("The office does not exist");
        }

        return new GetOffice(office);
    }
}
