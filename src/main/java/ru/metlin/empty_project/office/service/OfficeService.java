package ru.metlin.empty_project.office.service;

import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.view.GetOffice;
import ru.metlin.empty_project.office.view.OfficeList;

import java.util.List;

public interface OfficeService {

    SuccessView save(SaveOfficeRequest request);

    SuccessView update(UpdateOfficeRequest request);

    List<OfficeList> findAll(OfficeListRequest request);

    GetOffice findById(Long id);
}
