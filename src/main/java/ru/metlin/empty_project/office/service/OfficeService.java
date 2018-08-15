package ru.metlin.empty_project.office.service;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.response.GetOffice;
import ru.metlin.empty_project.office.response.OfficeList;

import java.util.List;

public interface OfficeService {

    SuccessView save(SaveOfficeRequest request) throws Exception;

    SuccessView update(UpdateOfficeRequest request) throws Exception;

    List<OfficeList> findAll() throws Exception;

    GetOffice findById(Long id) throws Exception;
}
