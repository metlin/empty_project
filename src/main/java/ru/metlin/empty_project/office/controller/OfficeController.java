package ru.metlin.empty_project.office.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.model.OfficeRepository;
import ru.metlin.empty_project.office.request.OfficeListRequest;
import ru.metlin.empty_project.office.request.SaveOfficeRequest;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    @Autowired
    private OfficeRepository officeRepository;

    @PostMapping(value = "/list")
    private Iterable<Office> getOfficeList(@RequestBody OfficeListRequest request) {
        return officeRepository.findAll();
}

    @GetMapping(value = "/{id}")
    private Optional<Office> getOffice(@PathVariable Long id) {
        return officeRepository.findById(id);
    }

    @PostMapping(value = "/save")
    private Office createOffice(@RequestBody SaveOfficeRequest request) {
        Office office = new Office(request);
        return officeRepository.save(office);
    }

    @PostMapping(value = "/update")
    private Office updateOffice(@RequestBody UpdateOfficeRequest request) {
        Office office = new Office(request);
        return officeRepository.save(office);
    }
}
