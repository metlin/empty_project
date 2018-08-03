package ru.metlin.empty_project.office.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;

import javax.transaction.Transactional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveOfficeRequest request) throws Exception {

        if (request.getOrgId() == 0) {
            throw new Exception("this office does not exist");
        }

        Office office = new Office(request);


        return officeDao.add(office);
    }

    @Override
    @Transactional
    public SuccessView update(UpdateOfficeRequest request) throws Exception {

        if (request.getOrgId() == 0) {
            throw new Exception("this office does not exist");
        }

        if (request.getId() == 0) {
            throw new Exception("this office does not exist");
        }

        if (request.getName() == null) {
            throw new Exception("this office does not exist");
        }

        if (request.getAddress() == null) {
            throw new Exception("this office does not exist");
        }

        Office office = new Office(request);

        return officeDao.add(office);
    }

    @Override
    @Transactional
    public Iterable<Office> findAll() {
        return officeDao.all();
    }

    @Override
    @Transactional
    public Office findById(Long id) throws Exception {

        if (id == 0) {
            throw new Exception("this office does not exist");
        }

        return officeDao.getById(id);
    }
}
