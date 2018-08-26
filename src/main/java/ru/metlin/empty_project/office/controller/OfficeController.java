package ru.metlin.empty_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.service.OfficeService;
import ru.metlin.empty_project.office.view.GetOffice;
import ru.metlin.empty_project.office.view.OfficeList;
import ru.metlin.empty_project.response.SuccessView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping(value = "/list")
    private List<OfficeList> getOfficeList(@RequestBody OfficeListRequest request) {

        return officeService.findAll(request);
    }

    @GetMapping(value = "/{id}")
    private GetOffice getOffice(@PathVariable Long id) {

        return officeService.findById(id);
    }

    @PostMapping(value = "/save")
    private SuccessView createOffice(@RequestBody SaveOfficeRequest request)  {

        return officeService.save(request);
    }

    @PostMapping(value = "/update")
    private SuccessView updateOffice(@RequestBody UpdateOfficeRequest request)  {

        return officeService.update(request);
    }
}
