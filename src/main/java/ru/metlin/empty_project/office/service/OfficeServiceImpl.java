package ru.metlin.empty_project.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Office save(SaveOfficeRequest request) {
        Office office = new Office(request);
        return officeDao.add(office);
    }

    @Override
    @Transactional
    public Office save(UpdateOfficeRequest request) {
        Office office = new Office();
        return officeDao.add(office);
    }

    @Override
    @Transactional
    public Iterable<Office> findAll() {
        return officeDao.all();
    }

    @Override
    @Transactional
    public Office findById(Long id) {
        return officeDao.getById(id);
    }
}
