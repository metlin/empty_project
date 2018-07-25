package ru.metlin.empty_project.office.service;

import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;

public interface OfficeService {

    Office save(SaveOfficeRequest request) throws Exception;

    Office save(UpdateOfficeRequest request) throws Exception;

    Iterable<Office> findAll();

    Office findById(Long id);
}
