package ru.metlin.empty_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.Response;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;
import ru.metlin.empty_project.office.service.OfficeService;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping(value = "/list")
    private Iterable<Office> getOfficeList(@RequestBody OfficeListRequest request) {
        return officeService.findAll();
}

    @GetMapping(value = "/{id}")
    private Response<Office> getOffice(@PathVariable Long id) throws Exception {
        try {
            return new Response<Office>(officeService.findById(id));
        } catch (Exception e) {
            return new Response<Office>(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    private Response<SuccessView> createOffice(@RequestBody SaveOfficeRequest request) throws Exception {
        try {
            return new Response<SuccessView>(officeService.save(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }

 /*   @PostMapping(value = "/update")
    private Office updateOffice(@RequestBody UpdateOfficeRequest request) throws Exception {
        return officeService.save(request);
    } */
}
