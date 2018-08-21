package ru.metlin.empty_project.office.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.response.GetOffice;
import ru.metlin.empty_project.office.response.OfficeList;
import ru.metlin.empty_project.organization.dao.OrganizationDao;
import ru.metlin.empty_project.organization.dao.OrganizationDaoImpl;
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

    public boolean validationByName(String name) throws Exception {
        if (name == null) {
            throw new Exception("this office does not exist");
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

    public boolean validationByPhone(String phone) throws Exception {

        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            throw new Exception("incorrect phone number");
        }

        return true;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOfficeRequest request) throws Exception {

        if (request.getOrgId() == 0) {
            throw new Exception("this office does not exist");
        }

        validationByName(request.getName());
        validationByPhone(request.getPhone());

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new Exception("Office should have an organization");
        }

        Office office = new Office(request);
        office.setOrganization(organization);
        organization.addOffice(office);

        officeDao.add(office);

        return new SuccessView();
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

        validationByName(request.getName());
        validationByPhone(request.getPhone());

        Organization organization = orgDao.getById(request.getOrgId());

        if (organization == null) {
            throw new Exception("Office should have an organization");
        }

        Office office = new Office(request);
        office.setOrganization(organization);

        officeDao.update(office);

        return new SuccessView();
    }

    @Override
    @Transactional
    public List<OfficeList> findAll(OfficeListRequest request) throws Exception {

        List<Office> officeList = officeDao.all(request);

        if (officeList.isEmpty()) {
            throw new Exception("officeList does not exist");
        }

        List<OfficeList> officeListResponse = new ArrayList<>();

        for (int i = 0; i < officeList.size(); i++) {
            officeListResponse.add(new OfficeList(officeList.get(i)));
        }

        return officeListResponse;
    }

    @Override
    @Transactional
    public GetOffice findById(Long id) throws Exception {

        if (id < 1) {
            throw new Exception("id greater than 0");
        }

        Office office = officeDao.getById(id);

        if (office == null) {
            throw new Exception("this office does not exist");
        }

        return new GetOffice(office);
    }
}
