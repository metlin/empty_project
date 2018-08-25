package ru.metlin.empty_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.office.service.OfficeService;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

 /*   @PostMapping(value = "/list")
    private Response<List<OfficeList>> getOfficeList(@RequestBody OfficeListRequest request) {
        try {
            return new Response<List<OfficeList>>(officeService.findAll(request));
        } catch (Exception e) {
            return new Response<List<OfficeList>>(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    private Response<GetOffice> getOffice(@PathVariable Long id) {
        try {
            return new Response<GetOffice>(officeService.findById(id));
        } catch (Exception e) {
            return new Response<GetOffice>(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    private Response<SuccessView> createOffice(@RequestBody SaveOfficeRequest request)  {
        try {
            return new Response<SuccessView>(officeService.save(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }

    @PostMapping(value = "/update")
    private Response<SuccessView> updateOffice(@RequestBody UpdateOfficeRequest request)  {
        try {
            return new Response<SuccessView>(officeService.update(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    } */
}
